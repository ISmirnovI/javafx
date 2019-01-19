package pingpong.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameController {
    @FXML
    private Rectangle firstPlayerPaddle;
    @FXML
    private Rectangle secondPlayerPaddle;
    @FXML
    private Circle ball;
    @FXML
    private Rectangle field;

    private Timeline timeline;

    double limitPaddleTopY;
    double limitPaddleBottomY;

    int paddleSpeed = 8;
    DoubleProperty currentFirstPlayerPaddleY = new SimpleDoubleProperty();
    DoubleProperty currentSecondPlayerPaddleY = new SimpleDoubleProperty();

    @FXML
    public void initialize() {
        System.out.println("GameController's ready. Let's bind some components");
        currentFirstPlayerPaddleY.set(firstPlayerPaddle.getLayoutY());
        firstPlayerPaddle.layoutYProperty().bind(currentFirstPlayerPaddleY);

        currentSecondPlayerPaddleY.set(secondPlayerPaddle.getLayoutY());
        secondPlayerPaddle.layoutYProperty().bind(currentSecondPlayerPaddleY);

        limitPaddleTopY = paddleSpeed;
        limitPaddleBottomY = field.getHeight() - firstPlayerPaddle.getHeight() - paddleSpeed;
    }

    public void listeners(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        System.out.println("Pressed: " + keyCode);
        switch (keyCode) {
            case UP:
                caseUp();
                break;
            case DOWN:
                caseDown();
                break;
            case W:
                caseW();
                break;
            case S:
                caseS();
                break;
            default:
                break;
        }
    }

    private void moveTheBall() {
        KeyFrame keyFrame = new KeyFrame(new Duration(10), event -> {

        }

        );
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();
    }

    private void caseUp() {
        if (currentSecondPlayerPaddleY.get() > limitPaddleTopY) {
            currentSecondPlayerPaddleY.set(currentSecondPlayerPaddleY.get() - paddleSpeed);
        }
    }

    private void caseDown() {
        if (currentSecondPlayerPaddleY.get() < limitPaddleBottomY) {
            currentSecondPlayerPaddleY.set(currentSecondPlayerPaddleY.get() + paddleSpeed);
        }
    }

    private void caseW() {
        if (currentFirstPlayerPaddleY.get() > limitPaddleTopY) {
            currentFirstPlayerPaddleY.set(currentFirstPlayerPaddleY.get() - paddleSpeed);
        }
    }


    private void caseS(){
        if (currentFirstPlayerPaddleY.get() < limitPaddleBottomY) {
            currentFirstPlayerPaddleY.set(currentFirstPlayerPaddleY.get() + paddleSpeed);
        }
    }

}

