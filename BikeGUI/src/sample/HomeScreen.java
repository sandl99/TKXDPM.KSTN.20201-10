package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class HomeScreen implements Initializable {
    @FXML
    private Button view_dock_list;
    @FXML
    private Button view_renting_bike;

    @FXML
    public void handleViewDockList(ActionEvent event) throws Exception {
        Stage stage = null;
//        Stage primary = null;
        Parent root = null;
        if (event.getSource() == view_dock_list) {
            stage = (Stage) view_dock_list.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("fxml/dock_list.fxml"));
        }
        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage = new Stage();
        stage.setScene(scene);
//        stage.setX(primary.getX() + 417);
//        stage.setY(primary.getY() + 289);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
