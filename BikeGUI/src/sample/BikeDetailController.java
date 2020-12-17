package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

public class BikeDetailController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
    
    public void closeButtonClicked(ActionEvent event)  throws IOException
	{
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.close();
	}
}