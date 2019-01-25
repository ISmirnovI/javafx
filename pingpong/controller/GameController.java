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
import java.util.Random;

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

    double centerTableY;

    double limitPaddleTopY;
    double limitPaddleBottomY;

    double initialSecondPlayerPaddleY;

    int paddleSpeed = 8;
    int ballSpeed = 3;

    DoubleProperty ballCenterX = new SimpleDoubleProperty();
    DoubleProperty ballCenterY = new SimpleDoubleProperty();

    DoubleProperty currentFirstPlayerPaddleY = new SimpleDoubleProperty();
    DoubleProperty currentSecondPlayerPaddleY = new SimpleDoubleProperty();

    @FXML
    public void initialize() {
        System.out.println("GameController's ready. Let's bind some components");
        currentFirstPlayerPaddleY.set(firstPlayerPaddle.getLayoutY());
        firstPlayerPaddle.layoutYProperty().bind(currentFirstPlayerPaddleY);

        initialSecondPlayerPaddleY = secondPlayerPaddle.getLayoutY();
        currentSecondPlayerPaddleY.set(initialSecondPlayerPaddleY);
        secondPlayerPaddle.layoutYProperty().bind(currentSecondPlayerPaddleY);

        limitPaddleTopY = paddleSpeed;
        limitPaddleBottomY = field.getHeight() - firstPlayerPaddle.getHeight() - paddleSpeed;

        ballCenterX.set(ball.getCenterX());
        ballCenterY.set(ball.getCenterY());

        ball.centerXProperty().bind(ballCenterX);
        ball.centerYProperty().bind(ballCenterY);

        centerTableY = field.getHeight()/2;
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
        Random randomYGenerator = new Random();

        double randomY = randomYGenerator.nextInt(ballSpeed);

        final boolean serveFromTop = (ballCenterY.get() <= centerTableY)?true:false;

        KeyFrame keyFrame = new KeyFrame(new Duration(10), event -> {
            if (ballCenterX.get() >= -20) {
                ballCenterX.set(ballCenterX.get() - ballSpeed);

                if (serveFromTop) {
                    ballCenterY.set(ballCenterY.get() + randomY);
                    currentSecondPlayerPaddleY.set( currentSecondPlayerPaddleY.get() + 1);

                }

                else {
                    ballCenterY.set(ballCenterY.get() - randomY);

                    currentSecondPlayerPaddleY.set(currentSecondPlayerPaddleY.get() - 1);
                }

                if(checkBallPaddleContact(secondPlayerPaddle)){
                    timeline.stop();
                    currentSecondPlayerPaddleY.set(initialSecondPlayerPaddleY);
                    bounceTheBall();
                }

            }
            else {
                timeline.stop();
                currentSecondPlayerPaddleY.set(initialSecondPlayerPaddleY);
            }
            updateScore();
        });


        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();
    }

    private boolean checkBallPaddleContact(Rectangle paddle){
        if (ball.intersects(paddle.getBoundsInParent())){
            return true;
        } else {
            return false;
        }
    }

    private void bounceTheBall() {
        double theBallOffTheTableX = field.getWidth() + 20;

        KeyFrame keyFrame = new KeyFrame(new Duration(10), event -> {

            if (ballCenterX.get() < theBallOffTheTableX) {
                ballCenterX.set(ballCenterX.get() + ballSpeed);
                if (checkBallPaddleContact(firstPlayerPaddle)){
                    timeline.stop();
                    moveTheBall();
                }

            }
            else {
                timeline.stop();
            }
            updateScore();
        });

        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();
    }

    private void updateScore(){
        int secondPlayerScore = 0;
        int firstPlayerScore = 0;
        if (ballCenterX.get() > field.getWidth()){
            secondPlayerScore ++;
        } else if (ballCenterY.get() > 0 && ballCenterY.get() <= field.getHeight()){
            firstPlayerScore++;
        } else{
            secondPlayerScore++;
        }


        System.out.println("2 Player: " + secondPlayerScore + " -:::- 1 player: " + firstPlayerScore);
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

    private void caseT() {
        ballCenterY.set(currentFirstPlayerPaddleY.doubleValue() + firstPlayerPaddle.getHeight()/2);
        ballCenterX.set(firstPlayerPaddle.getLayoutX());
        moveTheBall();
    }

}