package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.Bike;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Detail Bike Form
 * @author Group 10
 */

public class BikeDetailBoundary implements Initializable {

    @FXML
    private Label bikeId;
    @FXML
    private Label type;
    @FXML
    private Label barcode;
    @FXML
    private Label value;

    Bike bike;
    public BikeDetailBoundary(Bike bike) {
        this.bike = bike;
    }

    /**
     * initialize func
     * @param url url
     * @param resourceBundle resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.bikeId.setText("Bike " + bike.getId());
        this.type.setText(bike.getTypeString());

        this.barcode.setText(bike.getBarcode());
        this.value.setText(bike.getValue() + " VND");
    }

    /**
     * close clicked
     * @param event ActionEvent
     * @throws IOException Exception
     */
    public void closeButtonClicked(ActionEvent event)  throws IOException
	{
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.close();
	}
}