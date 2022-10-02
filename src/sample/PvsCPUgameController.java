package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PvsCPUgameController {
    @FXML
    public Button btn;
    @FXML
    public GridPane grid;


    public void click(ActionEvent event) throws Exception{
        grid.setStyle(  "-fx-background-size: 30px 10px ;"+
                "-fx-background-color: #ff0000; "  );
    }

}
