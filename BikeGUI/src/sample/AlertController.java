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

public class AlertController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
    
    public void yesButtonClicked(ActionEvent event)  throws IOException
	{
    	/***
    	 * xu li va tra lai form renting neu thue thanh cong, neu khong thi thong bao va tro lai bike_list
    	 */
    	Parent root = FXMLLoader.load(getClass().getResource("fxml/renting_detail.fxml"));
        Scene rentingDetailScene = new Scene(root);
        
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        primaryStage.close();
        
        Stage newStage = new Stage();
        newStage.setScene(rentingDetailScene);
        newStage.show();
	}
    
    public void noButtonClicked(ActionEvent event)  throws IOException
   	{
    	Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
          
    	primaryStage.close();
   	}
}