package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DockItemController implements Initializable {

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// TODO Auto-generated method stub
		
	}
	
	public void openButtonClicked(ActionEvent event)  throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("fxml/bike_list.fxml"));
        Scene bikeListScene = new Scene(root);
        
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        primaryStage.setScene(bikeListScene);
        primaryStage.show();
	}
}