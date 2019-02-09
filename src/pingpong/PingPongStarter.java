
package pingpong;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PingPongStarter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/ping-pong.fxml"));
        primaryStage.setTitle("Ping-Pong The Game");
        primaryStage.setScene(new Scene(root, 801, 488));
        primaryStage.show();

        root.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}