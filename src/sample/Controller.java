package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    public Button PvsCPU_Btn;
    @FXML
    public Button PvsP_Btn;


    public void Click_on_PvsCPU(ActionEvent event) throws IOException {

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/Player_vs_CPU.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Stage stage = (Stage) PvsCPU_Btn.getScene().getWindow();
        stage.close();
    }


    public void Click_on_PvsP(ActionEvent event) throws IOException {

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/Player_vs_Player.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Stage stage = (Stage) PvsP_Btn.getScene().getWindow();
        stage.close();

    }

}
