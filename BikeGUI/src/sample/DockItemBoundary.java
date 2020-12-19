package sample;

//import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.DockInfoController;
import entity.Dock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author san.dl170111
 */

public class DockItemBoundary implements Initializable {

	Dock dock;
	int numberBike;
	DockInfoController dockInfoController;

	@FXML
	protected Label name;
	@FXML
	protected Label address;
	@FXML
	protected Label numBike;

	public DockItemBoundary(Dock dock, int numBike, DockInfoController dockInfoController) {
		this.dock = dock;
		this.numberBike = numBike;
		this.dockInfoController = dockInfoController;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.name.setText(dock.getName());
		this.address.setText(dock.getAddress());
		this.numBike.setText(String.valueOf(numberBike));
	}
	@FXML
	public void openButtonClicked(ActionEvent event)  throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/bike_list.fxml"));
		BikeListBoundary bikeListBoundary = new BikeListBoundary(dockInfoController);
//		System.out.println(dockInfoController.getDock().toString());
		fxmlLoader.setController(bikeListBoundary);
		Parent root = fxmlLoader.load();
        Scene bikeListScene = new Scene(root);
        
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        primaryStage.setScene(bikeListScene);
        primaryStage.show();
	}
}