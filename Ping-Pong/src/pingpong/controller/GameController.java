package pingpong.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameController {
    @FXML
    private Rectangle firstPlayer;
    @FXML
    private Rectangle secondPlayer;
    @FXML
    private Circle ball;

    private Timeline timeline;

    @FXML
    public void initialize(){
        System.out.println("GameController's ready. Let's bind some components");
    }

    private void moveTheBall() {
        KeyFrame keyFrame = new KeyFrame(new Duration(10), event -> {

        }

        );
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();
    }

}

