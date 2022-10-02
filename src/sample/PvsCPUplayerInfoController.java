package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PvsCPUplayerInfoController extends PvsCPUController {

    @FXML
    public Label name_text;
    @FXML
    public Label wins_num_text;
    @FXML
    public Label losses_num_text;
    @FXML
    public Label wins_percent_text;
    @FXML
    public Label Rank_text;

    public void Show_btn(ActionEvent event) throws Exception{

        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(Login_username+".txt"));

            name_text .setText(bufferedReader.readLine());
            wins_num_text.setText(bufferedReader.readLine());
            losses_num_text.setText(bufferedReader.readLine());
            wins_percent_text.setText(bufferedReader.readLine());
            Rank_text.setText(bufferedReader.readLine());
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
