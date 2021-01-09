package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.Bike;
import entity.Dock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

/**
 * Bike view
 * @author Group 10
 */

public class BikeItemBoundary implements Initializable {
	Bike bike;
	Dock dock;
	@FXML
	private Label id;
	@FXML
	private Label address;
	@FXML
	private ProgressBar pin;

	public BikeItemBoundary(Bike bike, Dock dock) {
		this.bike = bike;
		this.dock = dock;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.id.setText("Bike " + bike.getId());
		this.address.setText(dock.getAddress());
		this.pin.setProgress(100);
	}

	/**
	 * view detail
	 * @param event ActionEvent
	 * @throws IOException IOException
	 */
	public void availableButtonClicked(ActionEvent event)  throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/bike_detail.fxml"));
		BikeDetailBoundary bikeDetailBoundary = new BikeDetailBoundary(bike);
		fxmlLoader.setController(bikeDetailBoundary);
		Parent root = fxmlLoader.load();
        Scene bikeListScene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(bikeListScene);
        primaryStage.show();
	}
}