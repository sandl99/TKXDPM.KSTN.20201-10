package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.stage.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DockItem implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void onClick(ActionEvent event) {
        try {
            System.out.println("User on click Dock");
            Parent loader = FXMLLoader.load(getClass().getResource("./fxml/bike_list.fxml"));
            Scene scene = new Scene(loader);

            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //this accesses the window.
            app_stage.setScene(scene); //This sets the scene as scene
            app_stage.show(); // this shows the scene
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
