package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DockList implements Initializable {

    @FXML // fx:id="dock_item"
    private VBox dock_item; // Value injected by FXMLLoader

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        Node[] node = new Node[18];

        for (int i = 0; i < node.length; i++) {
            try {
                node[i] = (Node) FXMLLoader.load(getClass().getResource("fxml/dock_item.fxml"));
                dock_item.getChildren().add(node[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
