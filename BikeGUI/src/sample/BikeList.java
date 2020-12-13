/**
 * Sample Skeleton for 'bike_list.fxml' Controller Class
 */

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BikeList implements Initializable {

    @FXML // fx:id="bike_item"
    private ListView<Node> listView; // Value injected by FXMLLoader

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Node[] node = new Node[18];

        for (int i = 0; i < node.length; i++) {
            try {
                node[i] = (Node) FXMLLoader.load(getClass().getResource("fxml/bike_item.fxml"));
                listView.getItems().add(node[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    
    /**
     * Rent a bike, if choose one -> alert box confirm yes/no, if no choice -> announ 
     * @param event
     * @throws IOException
     */
    public void rentABikeButtonClicked(ActionEvent event)  throws IOException
	{
//    	String selectedItem = listView.getSelectionModel().getSelectedItem();
//        int index = listView.getSelectionModel().getSelectedIndex();
    	Node bikeChosen = (Node)listView.getSelectionModel().getSelectedItem();  
    	if(bikeChosen != null)
    	{
    		Parent root = FXMLLoader.load(getClass().getResource("fxml/bike_form_renting.fxml"));
            Scene bikeFormRentingScene = new Scene(root);
            
            Stage newStage = new Stage();
            
            // Truyen bike vao
            newStage.setScene(bikeFormRentingScene);
            newStage.show();
    	} else
    	{
    		Parent root = FXMLLoader.load(getClass().getResource("fxml/barcode.fxml"));
            Scene barcodeScene = new Scene(root);
            
            Stage newStage = new Stage();
            
            // Truyen bike vao
            newStage.setScene(barcodeScene);
            newStage.show();
    	}
	}
    
    public void backButtonClicked(ActionEvent event)  throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("fxml/dock_list.fxml"));
        Scene dockListScene = new Scene(root);
        
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        primaryStage.setScene(dockListScene);
        primaryStage.show();
	}
}