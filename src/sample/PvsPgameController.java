package sample;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import jdk.nashorn.internal.ir.WhileNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class PvsPgameController extends PvsPController {

    @FXML
    public Canvas can1;
    @FXML
    public Canvas can2;
    @FXML
    public Label player2_ships_label;
    @FXML
    public Label player1_ships_label;
    @FXML
    public Label win_text;



    public GraphicsContext gc1;
    public GraphicsContext gc2;
    Ship[] Ships1 = new Ship[5];
    Ship[] Ships2 = new Ship[5];


    int ship_type =0;
    int ship_type2 =0;
    Map map1 = new Map();
    Map map2 = new Map();
    int counter = 0;
    int counter2 = 0;
    boolean turn1 = true;
    boolean turn2 = false;
    boolean start = false;
    int ships2_numbers =15;
    int ships1_numbers =15;
    int ready_flag=1;




    public void setup_ships1(MouseEvent mouseEvent){

        MouseButton button = mouseEvent.getButton();





        if (button == MouseButton.PRIMARY && counter<5 && turn1==true){

            double clicked_x = mouseEvent.getX();
            double clicked_y = mouseEvent.getY();
            int clicked_x_unit = (int) clicked_x / 40;
            int clicked_y_unit = (int) clicked_y / 40;
            int unit_x = clicked_x_unit+1;
            int unit_y = clicked_y_unit+1;
            int started_x = clicked_x_unit*40;
            int started_y = clicked_y_unit*40;
            ship_type = counter+1;

            boolean check = true;
            for (int i=0;i<ship_type;i++ ){
                try {
                    if (map1.isShip[(unit_x-1) + i][(unit_y-1)] == 1){
                        check = false;
                }
               }
                catch (Exception e){

                }
            }


            if ((unit_x+(counter)) <= 10 && map1.isShip[unit_x-1][unit_y-1] == 0 && check == true){

                for (int i=0;i<ship_type;i++ ){

                    map1.isShip[(unit_x-1) + i][(unit_y-1)] = 1;

                }


                Ships1[counter] = new Ship();




                Ships1[counter].Ship_length = ship_type;
                Ships1[counter].health = ship_type;
                Ships1[counter].destroyed =false;
                Ships1[counter].horizontal_direction = true;
                Ships1[counter].start_x =started_x;
                Ships1[counter].start_y = started_y;
                Ships1[counter].unit_x = unit_x;
                Ships1[counter].unit_y = unit_y;
                counter++;

                gc1 = can1.getGraphicsContext2D();
                gc1.setFill(Color.RED);

                int r=0;
                for (int a=0 ; a<ship_type;a++){
                    gc1.fillRect(started_x+1+r,started_y+1,38,38);
                    r=r+40;
                }



            }




        }
        else if (button == MouseButton.SECONDARY && counter<5 && turn1==true){

            double clicked_x = mouseEvent.getX();
            double clicked_y = mouseEvent.getY();
            int clicked_x_unit = (int) clicked_x / 40;
            int clicked_y_unit = (int) clicked_y / 40;
            int unit_x = clicked_x_unit+1;
            int unit_y = clicked_y_unit+1;
            int started_x = clicked_x_unit*40;
            int started_y = clicked_y_unit*40;

            ship_type = counter+1;

            boolean check = true;
            for (int i=0;i<ship_type;i++ ){
                try {
                    if (map1.isShip[(unit_x-1)][(unit_y-1)+i] == 1){
                        check = false;
                    }
                }
                catch (Exception e){

                }
            }


            if ((unit_y+(counter)) <= 10 && map1.isShip[unit_x-1][unit_y-1] == 0 && check == true){

                for (int i=0;i<ship_type;i++ ){

                    map1.isShip[(unit_x-1)][(unit_y-1) +i] = 1;

                }


                Ships1[counter] = new Ship();




                Ships1[counter].Ship_length = ship_type;
                Ships1[counter].health = ship_type;
                Ships1[counter].destroyed =false;
                Ships1[counter].horizontal_direction = false;
                Ships1[counter].start_x =started_x;
                Ships1[counter].start_y = started_y;
                Ships1[counter].unit_x = unit_x;
                Ships1[counter].unit_y = unit_y;
                counter++;

                gc1 = can1.getGraphicsContext2D();
                gc1.setFill(Color.RED);

                int r=0;
                for (int a=0 ; a<ship_type;a++){
                    gc1.fillRect(started_x+1,started_y+1+r,38,38);
                    r=r+40;
                }



            }

        }
         else  if (button == MouseButton.PRIMARY &&  start ==true && turn2==true){
            double clicked_x = mouseEvent.getX();
            double clicked_y = mouseEvent.getY();
            int clicked_x_unit = (int) clicked_x / 40;
            int clicked_y_unit = (int) clicked_y / 40;
            int unit_x = clicked_x_unit+1;
            int unit_y = clicked_y_unit+1;
            int started_x = clicked_x_unit*40;
            int started_y = clicked_y_unit*40;

            if (map1.isShip[unit_x-1][unit_y-1] ==1) {

                gc1 = can1.getGraphicsContext2D();
                gc1.setFill(Color.RED);
                gc1.fillRect(started_x + 1, started_y + 1, 38, 38);
                ships1_numbers--;
                if ( ships1_numbers ==0){
                    turn1 = false;
                    turn2 = false;
                    win_text.setText("Player2 won");


                }
                player1_ships_label.setText(""+ships1_numbers);
            }
                else if (map1.isShip[unit_x-1][unit_y-1] == 0){
                    gc1.setFill(Color.BLUE);
                    gc1.fillRect(started_x+1,started_y+1,38,38);
                    map1.isShip[unit_x-1][unit_y-1] = 2;
                    turn2 =false;
                    turn1 = true;

                }
                else if (map1.isShip[unit_x-1][unit_y-1] == 2 ){
                    turn2 = true;
                    turn1 = false;
            }




        }

}
    public void setup_ships2(MouseEvent mouseEvent){
        MouseButton button1 = mouseEvent.getButton();



          if (button1 == MouseButton.SECONDARY&& counter2<5 && turn2==true){

            double clicked_x = mouseEvent.getX();
            double clicked_y = mouseEvent.getY();
            int clicked_x_unit = (int) clicked_x / 40;
            int clicked_y_unit = (int) clicked_y / 40;
            int unit_x = clicked_x_unit+1;
            int unit_y = clicked_y_unit+1;
            int started_x = clicked_x_unit*40;
            int started_y = clicked_y_unit*40;

            ship_type2 = counter2+1;

            boolean check = true;
            for (int i=0;i<ship_type2;i++ ){
                try {
                    if (map2.isShip[(unit_x-1)][(unit_y-1)+i] == 1){
                        check = false;
                    }
                }
                catch (Exception e){

                }
            }


            if ((unit_y+(counter2)) <= 10 && map2.isShip[unit_x-1][unit_y-1] == 0 && check == true){

                for (int i=0;i<ship_type2;i++ ){

                    map2.isShip[(unit_x-1)][(unit_y-1) +i] = 1;

                }


                Ships2[counter2] = new Ship();




                Ships2[counter2].Ship_length = ship_type2;
                Ships2[counter2].health = ship_type2;
                Ships2[counter2].destroyed =false;
                Ships2[counter2].horizontal_direction = false;
                Ships2[counter2].start_x =started_x;
                Ships2[counter2].start_y = started_y;
                Ships2[counter2].unit_x = unit_x;
                Ships2[counter2].unit_y = unit_y;
                counter2++;

                gc2 = can2.getGraphicsContext2D();
                gc2.setFill(Color.GREEN);

                int r=0;
                for (int a=0 ; a<ship_type2;a++){
                    gc2.fillRect(started_x+1,started_y+1+r,38,38);
                    r=r+40;
                }



            }

        }

          else if (button1 == MouseButton.PRIMARY && counter2<5 && turn2==true){


              double clicked_x = mouseEvent.getX();
              double clicked_y = mouseEvent.getY();
              int clicked_x_unit = (int) clicked_x / 40;
              int clicked_y_unit = (int) clicked_y / 40;
              int unit_x = clicked_x_unit+1;
              int unit_y = clicked_y_unit+1;
              int started_x = clicked_x_unit*40;
              int started_y = clicked_y_unit*40;

              ship_type2 = counter2+1;

              boolean check = true;
              for (int i=0;i<ship_type2;i++ ){
                  try {
                      if (map2.isShip[(unit_x-1)+i][(unit_y-1)] == 1){
                          check = false;
                      }
                  }
                  catch (Exception e){

                  }
              }


              if ((unit_x+(counter2)) <= 10 && map2.isShip[unit_x-1][unit_y-1] == 0 && check == true){

                  for (int i=0;i<ship_type2;i++ ){

                      map2.isShip[(unit_x-1)+i][(unit_y-1) ] = 1;

                  }


                  Ships2[counter2] = new Ship();



                  Ships2[counter2].Ship_length = ship_type2;
                  Ships2[counter2].health = ship_type2;
                  Ships2[counter2].destroyed =false;
                  Ships2[counter2].horizontal_direction = true;
                  Ships2[counter2].start_x =started_x;
                  Ships2[counter2].start_y = started_y;
                  Ships2[counter2].unit_x = unit_x;
                  Ships2[counter2].unit_y = unit_y;
                  counter2++;

                  gc2 = can2.getGraphicsContext2D();
                  gc2.setFill(Color.GREEN);

                  int r=0;
                  for (int a=0 ; a<ship_type2;a++){
                      gc2.fillRect(started_x+1+r,started_y+1,38,38);
                      r=r+40;
                  }



              }


          }

          else if (button1 == MouseButton.PRIMARY &&  start ==true && turn1==true){

              double clicked_x = mouseEvent.getX();
              double clicked_y = mouseEvent.getY();
              int clicked_x_unit = (int) clicked_x / 40;
              int clicked_y_unit = (int) clicked_y / 40;
              int unit_x = clicked_x_unit+1;
              int unit_y = clicked_y_unit+1;
              int started_x = clicked_x_unit*40;
              int started_y = clicked_y_unit*40;

              if (map2.isShip[unit_x-1][unit_y-1] ==1) {

                  gc2 = can2.getGraphicsContext2D();
                  gc2.setFill(Color.GREEN);
                  gc2.fillRect(started_x + 1, started_y + 1, 38, 38);
                  ships2_numbers--;
                  if ( ships2_numbers ==0){
                      turn1 = false;
                      turn2 = false;
                      win_text.setText("Player1 won");

                  }
                  player2_ships_label.setText(""+ships2_numbers);
              }
              else if (map2.isShip[unit_x-1][unit_y-1] == 0){
                  gc2.setFill(Color.BLUE);
                  gc2.fillRect(started_x+1,started_y+1,38,38);
                  map2.isShip[unit_x-1][unit_y-1] = 2;
                  turn1 =false;
                  turn2 = true;

              }
              else if (map2.isShip[unit_x-1][unit_y-1] == 2 ){
                  turn1 = true;
                  turn2 = false;
              }

          }

    }
    public void click_on_ready1_btn(ActionEvent event) throws IOException{
        if (ready_flag == 1) {
            turn1 = false;
            turn2 = true;
            for (int i = 0; i < 5; i++) {
                if (Ships1[i].horizontal_direction == true) {

                    gc1 = can1.getGraphicsContext2D();
                    gc1.setFill(Color.rgb(221, 221, 221));

                    int r = 0;
                    for (int a = 0; a < Ships1[i].Ship_length; a++) {
                        gc1.fillRect(Ships1[i].start_x + 1 + r, Ships1[i].start_y + 1, 38, 38);
                        r = r + 40;
                    }
                } else if (Ships1[i].horizontal_direction == false) {

                    gc1 = can1.getGraphicsContext2D();
                    gc1.setFill(Color.rgb(221, 221, 221));

                    int r = 0;
                    for (int a = 0; a < Ships1[i].Ship_length; a++) {
                        gc1.fillRect(Ships1[i].start_x + 1, Ships1[i].start_y + 1 + r, 38, 38);
                        r = r + 40;
                    }


                }
            }
            ready_flag =2;
        }
    }
    public void click_on_ready2_btn(ActionEvent event) throws  IOException {
        if (ready_flag == 2) {

            turn1 = true;
            turn2 = false;
            start = true;
            ready_flag = 0;
            for (int i = 0; i < 5; i++) {
                if (Ships2[i].horizontal_direction == true) {

                    gc2 = can2.getGraphicsContext2D();
                    gc2.setFill(Color.rgb(221, 221, 221));

                    int r = 0;
                    for (int a = 0; a < Ships2[i].Ship_length; a++) {
                        gc2.fillRect(Ships2[i].start_x + 1 + r, Ships2[i].start_y + 1, 38, 38);
                        r = r + 40;
                    }
                } else if (Ships2[i].horizontal_direction == false) {

                    gc2 = can2.getGraphicsContext2D();
                    gc2.setFill(Color.rgb(221, 221, 221));

                    int r = 0;
                    for (int a = 0; a < Ships2[i].Ship_length; a++) {
                        gc2.fillRect(Ships2[i].start_x + 1, Ships2[i].start_y + 1 + r, 38, 38);
                        r = r + 40;
                    }


                }
            }
        }

    }
}











