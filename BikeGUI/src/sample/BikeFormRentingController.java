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

public class BikeFormRentingController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
    
    public void confirmButtonClicked(ActionEvent event)  throws IOException
	{
    	Parent root = FXMLLoader.load(getClass().getResource("fxml/Alert.fxml"));
        Scene alertScene = new Scene(root);
        
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.close();
        
        Stage newStage = new Stage();
        
        newStage.setScene(alertScene);
        newStage.show();
	}
}