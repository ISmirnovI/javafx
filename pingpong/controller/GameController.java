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

    double limitLeftSideX;
    double limitRightSideX;
    double limitBottomBallY;

    int paddleSpeed = 8;
    int ballSpeedX = 2;
    int ballSpeedY = 2;


    DoubleProperty currentBallY = new SimpleDoubleProperty();
    DoubleProperty currentBallX = new SimpleDoubleProperty();

    DoubleProperty currentFirstPlayerPaddleY = new SimpleDoubleProperty();
    DoubleProperty currentSecondPlayerPaddleY = new SimpleDoubleProperty();

    @FXML
    public void initialize() {
        System.out.println("GameController's ready. Let's bind some components");

        currentBallX.set(ball.getLayoutX());
        ball.layoutXProperty().bind(currentBallX);

        currentBallY.set(ball.getLayoutY());
        ball.layoutYProperty().bind(currentBallY);


        currentFirstPlayerPaddleY.set(firstPlayerPaddle.getLayoutY());
        firstPlayerPaddle.layoutYProperty().bind(currentFirstPlayerPaddleY);

        currentSecondPlayerPaddleY.set(secondPlayerPaddle.getLayoutY());
        secondPlayerPaddle.layoutYProperty().bind(currentSecondPlayerPaddleY);

        limitPaddleTopY = paddleSpeed -10;
        limitPaddleBottomY = field.getHeight() - firstPlayerPaddle.getHeight() - paddleSpeed;

        limitBottomBallY = field.getHeight();

        limitLeftSideX = 0;
        limitRightSideX = field.getWidth();
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
            case T:
                caseT();
                break;
            default:
                break;
        }
    }

    private void moveTheBall() {

        KeyFrame keyFrame = new KeyFrame(new Duration(10), event -> {
            currentBallY.set(currentBallY.get() + ballSpeedY);
            currentBallX.set(currentBallX.get() + ballSpeedX);
            checkBallWallContact();
            checkBallPaddle1Contact();
            checkBallPaddle2Contact();
        }

        );
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();
    }

    private void checkBallWallContact(){
        if((currentBallX.get() <= ball.getRadius()||(currentBallX.get() >= limitRightSideX - ball.getRadius()))){
           ballSpeedX = ballSpeedX * (-1);
        }
        if((currentBallY.get() <= limitPaddleTopY + ball.getRadius()||(currentBallY.get() >= limitBottomBallY - ball.getRadius()))){
            ballSpeedY = ballSpeedY * (-1);
        }
    }
    private void checkBallPaddle1Contact(){
        if((currentBallX.get() >= secondPlayerPaddle.getLayoutX() - secondPlayerPaddle.getWidth()/2)&&((currentBallY.get() <= currentSecondPlayerPaddleY.get() + secondPlayerPaddle.getHeight()/2)&&(currentBallY.get() >= currentSecondPlayerPaddleY.get()  - secondPlayerPaddle.getHeight()/2))){
            ballSpeedX = ballSpeedX * (-1);
        }
    }
    private void checkBallPaddle2Contact(){
        if((currentBallX.get() <= firstPlayerPaddle.getLayoutX() + firstPlayerPaddle.getWidth()/2)&&((currentBallY.get() <= currentFirstPlayerPaddleY.get() + firstPlayerPaddle.getHeight()/2)&&(currentBallY.get() >= currentFirstPlayerPaddleY.get()  - firstPlayerPaddle.getHeight()/2))){
            ballSpeedX = ballSpeedX * (-1);
        }
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

    private void caseT(){
        moveTheBall();
    }

}

