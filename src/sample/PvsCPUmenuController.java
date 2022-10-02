package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PvsCPUmenuController {

    @FXML
    public Button Start_game_btn;
    @FXML
    public Button Show_profile_btn;

    public void Click_on_start_game_btn (ActionEvent event) throws Exception{

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/PvsCPUgame.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Stage stage = (Stage) Start_game_btn.getScene().getWindow();
        stage.close();
    }

    public void Click_on_show_profile_btn (ActionEvent event) throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/PvsCPUplayerInfo.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Stage stage = (Stage) Show_profile_btn.getScene().getWindow();
        stage.close();
    }

}
