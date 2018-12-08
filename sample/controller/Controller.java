package sample.controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
public class Controller {
    @FXML
    private TextField field;
    SimpleStringProperty text = new SimpleStringProperty();

    @FXML
    public void initialize() {
        System.out.println("Controller's ready. Let's bind some components");
        text.set("");
        field.textProperty().bind(text);
    }
    public void onMCIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка 'MC' нажата.");
        }
        public void onMCPlusIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка 'MC+' нажата.");
        }
        public void onMCMinusIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка 'MC-' нажата.");
        }
        public void onMRIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка 'MR' нажата.");
        }
        public void onCIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка 'C' нажата.");
        }
        public void onPlusMinusIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '+-' нажата.");
        }
        public void onDivisionIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '/' нажата.");
            text.set(text.getValue()+"/");
        }
        public void onMultiplyIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка 'X' нажата.");
            text.set(text.getValue()+"X");
        }
        public void on7IsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '7' нажата.");
            text.set(text.getValue()+"7");
        }
        public void on8IsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '8' нажата.");
            text.set(text.getValue()+"8");
        }
        public void on9IsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '9' нажата.");
            text.set(text.getValue()+"9");
        }
        public void onMinusIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '-' нажата.");
            text.set(text.getValue()+"-");
        }
        public void on4IsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '4' нажата.");
            text.set(text.getValue()+"4");
        }
        public void on5IsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '5' нажата.");
            text.set(text.getValue()+"5");
        }
        public void on6IsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '6' нажата.");
            text.set(text.getValue()+"6");
        }
        public void onPlusIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '+' нажата.");
            text.set(text.getValue()+"+");
        }
        public void on1IsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '1' нажата.");
            text.set(text.getValue()+"1");
        }
        public void on2IsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '2' нажата.");
            text.set(text.getValue()+"2");
        }
        public void on3IsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '3' нажата.");
            text.set(text.getValue()+"3");
        }
        public void onPointIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '.' нажата.");
            text.set(text.getValue()+".");
        }
        public void on0IsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '0' нажата.");
            text.set(text.getValue()+"0");
        }
        public void onEqualIsClick(ActionEvent actionEvent) {
            System.out.println("Кнопка '=' нажата.");
            text.set(text.getValue()+"=");
        }
    }



