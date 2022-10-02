package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class PvsPController {

    @FXML
    public TextField Player1_text;
    @FXML
    public TextField Player2_text;
    @FXML
    public Button Login_Btn;
    @FXML
    public Button Signup_Btn;
    @FXML
    public Label Status;

    static String Login_username1;
    static String Login_username2;

    public void Click_on_Signup_Btn(ActionEvent event) throws IOException {


        String filePath = "UserInfo.txt";
        String username1;
        String username2;

        username1 = Player1_text.getText();
        username2 = Player2_text.getText();
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader((new FileReader(filePath)));
            String line;
            boolean usernameExists = false;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(username1) || line.equals(username2)) {
                    usernameExists = true;
                    break;
                }

            }
            if (usernameExists) {
                Status.setText("Username is already taken!");
            } else if (username1 != null && username2 != null) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
                writer.write(username1);
                writer.newLine();
                writer.write(username2);
                writer.newLine();
                writer.close();

                Player player1 = new Player();
                Player player2 = new Player();
                player1.name = username1;
                player2.name = username2;

                PrintWriter writer0 = new PrintWriter(username1+".txt");

                BufferedWriter writer1 = new BufferedWriter(new FileWriter(username1+".txt",true));
                writer1.write(player1.name);
                writer1.newLine();
                writer1.write(new Integer(player1.losses_number).toString());
                writer1.newLine();
                writer1.write(new Integer(player1.wins_number).toString());
                writer1.newLine();
                writer1.write(new Integer(player1.wins_percent).toString());
                writer1.newLine();
                writer1.write(new Integer(player1.rank).toString());
                writer1.newLine();
                writer1.close();

                BufferedWriter writer2 = new BufferedWriter(new FileWriter(username2+".txt",true));
                writer2.write(player2.name);
                writer2.newLine();
                writer2.write(new Integer(player2.losses_number).toString());
                writer2.newLine();
                writer2.write(new Integer(player2.wins_number).toString());
                writer2.newLine();
                writer2.write(new Integer(player2.wins_percent).toString());
                writer2.newLine();
                writer2.write(new Integer(player2.rank).toString());
                writer2.newLine();
                writer2.close();

                Status.setText("sign up successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void Click_on_Login_Btn(ActionEvent event) throws IOException {

        String filePath = "UserInfo.txt";
        //String Login_username1;
       // String Login_username2;
        Login_username1 = Player1_text.getText();
        Login_username2 = Player2_text.getText();
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader((new FileReader(filePath)));
            String line;
            Boolean username1Exists = false;
            Boolean username2Exists = false;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(Login_username1)) {
                    username1Exists = true;
                } else if (line.equals(Login_username2)) {
                    username2Exists = true;
                    break;
                }
            }
            if (username1Exists && username2Exists) {
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/sample/PvsPmenu.fxml"));
                primaryStage.setScene(new Scene(root));
                primaryStage.show();

                Stage stage = (Stage) Login_Btn.getScene().getWindow();
                stage.close();
            } else if (username1Exists && username2Exists != null) {
                Status.setText("Player2 dose not exist!");
            } else if (username1Exists != null && username2Exists) {
                Status.setText("Player1 dose not exist!");
            } else if (username1Exists != null && username2Exists != null) {
                Status.setText("There are no players!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}