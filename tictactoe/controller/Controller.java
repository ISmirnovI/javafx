package tictactoe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Controller {
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    public void initialize() {
        System.out.println("Controller's ready. Let's bind some components");

    }

    private boolean firstPlayerTurn = true;
    private boolean lockButton1 = false;
    private boolean lockButton2 = false;
    private boolean lockButton3 = false;
    private boolean lockButton4 = false;
    private boolean lockButton5 = false;
    private boolean lockButton6 = false;
    private boolean lockButton7 = false;
    private boolean lockButton8 = false;
    private boolean lockButton9 = false;


    public void button1IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 1 нажата");
        block(1);
    }
    public void button2IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 2 нажата");
        block(2);
    }
    public void button3IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 3 нажата");
        block(3);
    }
    public void button4IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 4 нажата");
        block(4);
    }
    public void button5IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 5 нажата");
        block(5);
    }
    public void button6IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 6 нажата");
        block(6);
    }
    public void button7IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 7 нажата");
        block(7);
    }
    public void button8IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 8 нажата");
        block(8);
    }
    public void button9IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 9 нажата");
        block(9);
    }

    private void block(int buttonNumber){
        switch(buttonNumber){
            case 1:
                if(!lockButton1){
                    if(firstPlayerTurn) {
                        button1.setText("X");
                        firstPlayerTurn = false;
                    }else{
                        button1.setText("O");
                        firstPlayerTurn = true;
                    }
                    lockButton1 = true;
                }
                break;
            case 2:
                if(!lockButton2){
                    if(firstPlayerTurn) {
                        button2.setText("X");
                        firstPlayerTurn = false;
                    }else{
                        button2.setText("O");
                        firstPlayerTurn = true;
                    }
                    lockButton2 = true;
                }
                break;
            case 3:
                if(!lockButton3){
                    if(firstPlayerTurn) {
                        button3.setText("X");
                        firstPlayerTurn = false;
                    }else{
                        button3.setText("O");
                        firstPlayerTurn = true;
                    }
                    lockButton3 = true;
                }
                break;
            case 4:
                if(!lockButton4){
                    if(firstPlayerTurn) {
                        button4.setText("X");
                        firstPlayerTurn = false;
                    }else{
                        button4.setText("O");
                        firstPlayerTurn = true;
                    }
                    lockButton4 = true;
                }
                break;
            case 5:
                if(!lockButton5){
                    if(firstPlayerTurn) {
                        button5.setText("X");
                        firstPlayerTurn = false;
                    }else{
                        button5.setText("O");
                        firstPlayerTurn = true;
                    }
                    lockButton5 = true;
                }
                break;
            case 6:
                if(!lockButton6){
                    if(firstPlayerTurn) {
                        button6.setText("X");
                        firstPlayerTurn = false;
                    }else{
                        button6.setText("O");
                        firstPlayerTurn = true;
                    }
                    lockButton6 = true;
                }
                break;
            case 7:
                if(!lockButton7){
                    if(firstPlayerTurn) {
                        button7.setText("X");
                        firstPlayerTurn = false;
                    }else{
                        button7.setText("O");
                        firstPlayerTurn = true;
                    }
                    lockButton7 = true;
                }
                break;
            case 8:
                if(!lockButton8){
                    if(firstPlayerTurn) {
                        button8.setText("X");
                        firstPlayerTurn = false;
                    }else{
                        button8.setText("O");
                        firstPlayerTurn = true;
                    }
                    lockButton8 = true;
                }
                break;
            case 9:
                if(!lockButton9){
                    if(firstPlayerTurn) {
                        button9.setText("X");
                        firstPlayerTurn = false;
                    }else{
                        button9.setText("O");
                        firstPlayerTurn = true;
                    }
                    lockButton9 = true;
                }
                break;
        }
    }
}
