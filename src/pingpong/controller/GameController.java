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

import javax.xml.soap.Text;

public class GameController {
    @FXML
    private Rectangle firstPlayerPaddle;
    @FXML
    private Rectangle secondPlayerPaddle;
    @FXML
    private Circle ball;
    @FXML
    private Rectangle field;
    @FXML
    private Text score;

    private Timeline timeline;

    double limitPaddleTopY;
    double limitPaddleBottomY;

    double limitLeftSideX;
    double limitRightSideX;
    double limitBottomBallY;
    private int direction;

    int paddleSpeed = 8;
    double ballSpeedX = 1.5;
    double ballSpeedY = 1.5;
    double ballSpeedXStatic = 1.5;
    double ballSpeedYStatic = 1.5;

    double startPositionFirstPaddle;
    double startPositionSecondPaddle;
    double startPositionBallY;
    double startPositionBallX;

    DoubleProperty currentBallY = new SimpleDoubleProperty();
    DoubleProperty currentBallX = new SimpleDoubleProperty();

    DoubleProperty currentFirstPlayerPaddleY = new SimpleDoubleProperty();
    DoubleProperty currentSecondPlayerPaddleY = new SimpleDoubleProperty();

    @FXML
    public void initialize() {
        System.out.println("GameController's ready. Let's bind some components");

        currentBallX.set(ball.getLayoutX());
        ball.layoutXProperty().bind(currentBallX);
        startPositionBallX = currentBallX.get();

        currentBallY.set(ball.getLayoutY());
        ball.layoutYProperty().bind(currentBallY);
        startPositionBallY = currentBallY.get();


        currentFirstPlayerPaddleY.set(firstPlayerPaddle.getLayoutY());
        firstPlayerPaddle.layoutYProperty().bind(currentFirstPlayerPaddleY);
        startPositionFirstPaddle = currentFirstPlayerPaddleY.get();

        currentSecondPlayerPaddleY.set(secondPlayerPaddle.getLayoutY());
        secondPlayerPaddle.layoutYProperty().bind(currentSecondPlayerPaddleY);
        startPositionSecondPaddle = currentSecondPlayerPaddleY.get();

        limitPaddleTopY = paddleSpeed - 10;
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
                direction = 1 + (int) (Math.random() * 4);
                switch (direction){
                    case 1:
                        ballSpeedX = Math.abs(ballSpeedXStatic);
                        ballSpeedY = Math.abs(ballSpeedYStatic);
                        moveTheBall();
                        updateScore();
                        break;
                    case 2:
                        ballSpeedX = Math.abs(ballSpeedXStatic);
                        ballSpeedY = -Math.abs(ballSpeedYStatic);
                        moveTheBall();
                        updateScore();
                        break;
                    case 3:
                        ballSpeedX = -Math.abs(ballSpeedXStatic);
                        ballSpeedY = Math.abs(ballSpeedYStatic);
                        moveTheBall();
                        updateScore();
                        break;
                    case 4:
                        ballSpeedX = -Math.abs(ballSpeedXStatic);
                        ballSpeedY = -Math.abs(ballSpeedYStatic);
                        moveTheBall();
                        updateScore();
                        break;
                }
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
            endGamePositionsAndScore();
            checkTouchBallAndSecondPaddle();
            checkTouchBallAndFirstPaddle();
        }

        );
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();
    }

    private void checkBallWallContact() {

        if ((currentBallY.get() <= limitPaddleTopY + ball.getRadius() || (currentBallY.get() >= limitBottomBallY - ball.getRadius()))) {
            ballSpeedY = ballSpeedY * (-1);
        }
    }

    private void checkTouchBallAndSecondPaddle() {
        if ((currentBallX.get() >= secondPlayerPaddle.getLayoutX() - secondPlayerPaddle.getWidth() )
                && ((currentBallY.get() <= currentSecondPlayerPaddleY.get() + secondPlayerPaddle.getHeight() / 2 + 40)
                && (currentBallY.get() >= currentSecondPlayerPaddleY.get() - secondPlayerPaddle.getHeight() / 2 + 40))) {
            ballSpeedX = - Math.abs(ballSpeedX);
        }
    }

    private void checkTouchBallAndFirstPaddle() {
        if ((currentBallX.get() <= firstPlayerPaddle.getLayoutX() + 20) && ((currentBallY.get() <= currentFirstPlayerPaddleY.get() + firstPlayerPaddle.getHeight() / 2 + 40) && (currentBallY.get() >= currentFirstPlayerPaddleY.get() - firstPlayerPaddle.getHeight() / 2 + 40))) {
            ballSpeedX = Math.abs(ballSpeedX);
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


    private void caseS() {
        if (currentFirstPlayerPaddleY.get() < limitPaddleBottomY) {
            currentFirstPlayerPaddleY.set(currentFirstPlayerPaddleY.get() + paddleSpeed);
        }
    }

    private void endGamePositionsAndScore(){
        if ((currentBallX.get() <= limitLeftSideX + ball.getRadius()) || (currentBallX.get() >= limitRightSideX - ball.getRadius())) {

            currentFirstPlayerPaddleY.set(startPositionFirstPaddle);
            currentSecondPlayerPaddleY.set(startPositionSecondPaddle);
            currentBallY.set(startPositionBallY);
            currentBallX.set(startPositionBallX);
            timeline.stop();
        }
    }
    int firstPlayerScore = 0;
    int secondPlayerScore = 0;
    private void updateScore(){
        if (currentBallX.get() <= limitLeftSideX + ball.getRadius()){
            secondPlayerScore++;
            score.setTextContent(firstPlayerScore + ":" + secondPlayerScore);
        }
        if (currentBallX.get() >= limitRightSideX - ball.getRadius()){
            firstPlayerScore++;
            score.setTextContent(firstPlayerScore + ":" + secondPlayerScore);
        }
    }

}