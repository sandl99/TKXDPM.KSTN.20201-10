/**
 * Sample Skeleton for 'bike_list.fxml' Controller Class
 */

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BikeList implements Initializable {

    @FXML // fx:id="bike_item"
    private VBox bike_item; // Value injected by FXMLLoader
    @FXML
    private Button rent_bike_btn;

    @FXML
    public void handleRentBikeButtion(ActionEvent event) throws Exception {
        Stage stage = null;
        Stage primary = null;
        Parent root = null;
        if (event.getSource() == rent_bike_btn) {
            primary = (Stage) rent_bike_btn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("fxml/barcode.fxml"));
        }
        Scene scene = new Scene(root);
//        stage.setScene(scene);
        stage = new Stage();
        stage.setScene(scene);
        stage.setX(primary.getX() + 417);
        stage.setY(primary.getY() + 289);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Node[] node = new Node[18];

        for (int i = 0; i < node.length; i++) {
            try {
                node[i] = (Node) FXMLLoader.load(getClass().getResource("fxml/bike_item.fxml"));
                bike_item.getChildren().add(node[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}