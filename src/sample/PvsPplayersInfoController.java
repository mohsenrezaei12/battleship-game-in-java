package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PvsPplayersInfoController extends PvsPController {

    @FXML
    public Label name1_text;
    @FXML
    public Label name2_text;
    @FXML
    public Label wins_num1_text;
    @FXML
    public Label wins_num2_text;
    @FXML
    public Label losses_num1_text;
    @FXML
    public Label losses_num2_text;
    @FXML
    public Label wins_percent1_text;
    @FXML
    public Label wins_percent2_text;
    @FXML
    public Label rank1_text;
    @FXML
    public Label rank2_text;


public void Show_btn() throws Exception{

    BufferedReader bufferedReader1;
    BufferedReader bufferedReader2;

    try {
        bufferedReader1 = new BufferedReader((new FileReader(Login_username1+".txt")));

        name1_text .setText(bufferedReader1.readLine());
        wins_num1_text.setText(bufferedReader1.readLine());
        losses_num1_text.setText(bufferedReader1.readLine());
        wins_percent1_text.setText(bufferedReader1.readLine());
        rank1_text.setText(bufferedReader1.readLine());
        bufferedReader1.close();

        bufferedReader2 = new BufferedReader(new FileReader(Login_username2+".txt"));

        name2_text .setText(bufferedReader2.readLine());
        wins_num2_text.setText(bufferedReader2.readLine());
        losses_num2_text.setText(bufferedReader2.readLine());
        wins_percent2_text.setText(bufferedReader2.readLine());
        rank2_text.setText(bufferedReader2.readLine());
        bufferedReader2.close();

    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }


}

}












