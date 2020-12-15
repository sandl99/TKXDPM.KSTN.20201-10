package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BikeItemController implements Initializable {

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// TODO Auto-generated method stub
		
	}

	public void availableButtonClicked(ActionEvent event)  throws IOException
	{
		
		Parent root = FXMLLoader.load(getClass().getResource("fxml/bike_detail.fxml"));
        Scene bikeListScene = new Scene(root);
        
        Stage primaryStage = new Stage();
        
        primaryStage.setScene(bikeListScene);
        primaryStage.show();
	}
}