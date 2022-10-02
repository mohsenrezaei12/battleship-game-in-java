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


public class PvsCPUController {
    @FXML
    public TextField Player_text;
    @FXML
    public Label Status;
    @FXML
    public Button Login_Button;
    @FXML
    public Button Signup_Button;



    static String Login_username;

    public void Click_on_Signup_Button(ActionEvent event) throws IOException{
        String username;
        String filePath = "UserInfo.txt";
        username = Player_text.getText();
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean usernameExists = false;
            while ((line = bufferedReader.readLine()) != null){
                if (line.equals(username)){
                    usernameExists = true;
                    break;
                }
            }
            if (usernameExists){
                Status.setText("Username is already taken!");
            }
            else if ( username != null)
            {
                Player player = new Player();
                player.name = username;

                PrintWriter writer0 = new PrintWriter(username+".txt");
                BufferedWriter writer1 = new BufferedWriter(new FileWriter(username+".txt",true));

                writer1.write(player.name);
                writer1.newLine();
                writer1.write(new Integer(player.losses_number).toString());
                writer1.newLine();
                writer1.write(new Integer(player.wins_number).toString());
                writer1.newLine();
                writer1.write(new Integer(player.wins_percent).toString());
                writer1.newLine();
                writer1.write(new Integer(player.rank).toString());
                writer1.newLine();
                writer1.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
                writer.write(username);
                writer.newLine();
                writer.close();
                Status.setText("sign up successfully.");

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void Click_on_Login_Button(ActionEvent event) throws IOException{

        String filepath = "UserInfo.txt";
        //String Login_username;
        Login_username = Player_text.getText();
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader((new FileReader(filepath)));
            String line;
            Boolean usernameExists = false;
            while ((line = bufferedReader.readLine()) != null){
                if (line.equals(Login_username)){
                    usernameExists = true;
                    break;
                }
            }
            if (usernameExists){
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/sample/PvsCPUmenu.fxml"));
                primaryStage.setScene(new Scene(root));
                primaryStage.show();

                Stage stage = (Stage) Login_Button.getScene().getWindow();
                stage.close();
            }
            else {
                Status.setText("Player dose not exist!");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
