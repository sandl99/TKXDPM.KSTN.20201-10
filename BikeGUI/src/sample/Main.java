package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.concurrent.TimeUnit;

public class Main extends Application {

    private double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/home_screen.fxml"));
        primaryStage.setScene(new Scene(root));

//        primaryStage.initStyle(StageStyle.UNDECORATED);

        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            primaryStage.setX(mouseEvent.getSceneX() - x);
            primaryStage.setY(mouseEvent.getSceneY() - y);
        });
        primaryStage.show();
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        root = FXMLLoader.load(getClass().getResource("fxml/home_screen.fxml"));
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
