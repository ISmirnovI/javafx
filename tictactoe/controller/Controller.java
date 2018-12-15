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
        button1.setText("X");
    }
    public void button2IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 2 нажата");
        button2.setText("X");
    }
    public void button3IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 3 нажата");
        button3.setText("X");
    }
    public void button4IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 4 нажата");
        button4.setText("X");
    }
    public void button5IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 5 нажата");
        button5.setText("X");
    }
    public void button6IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 6 нажата");
        button6.setText("X");
    }
    public void button7IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 7 нажата");
        button7.setText("X");
    }
    public void button8IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 8 нажата");
        button8.setText("X");
    }
    public void button9IsClicked(ActionEvent actionEvent){
        System.out.println("Кнопка 9 нажата");
        button9.setText("X");
    }
    public void block(int buttonNumber){
        switch(buttonNumber){
            case 1:

        }
    }
}
