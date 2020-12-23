package sample;

import controller.DockInfoController;
import controller.DockListController;
import entity.Dock;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Random;

/**
 * Dock List
 * @author Group 10
 */

public class DockListBoundary implements Initializable {

    @FXML // fx:id="dock_item"
    private VBox dock_item; // Value injected by FXMLLoader

    DockListController dockListController;
    DockInfoController dockInfoController;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        dockListController = new DockListController();

        List<Dock> docks = dockListController.getDocks();
        Node[] node = new Node[docks.size()];
//        System.out.println(docks == null);
        for (int i = 0; i < node.length; i++) {
            try {
                dockInfoController = new DockInfoController(docks.get(i));
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/dock_item.fxml"));
                int numBike = dockInfoController.getNumBike();
                DockItemBoundary dockItemBoundary = new DockItemBoundary(docks.get(i), numBike, dockInfoController);
                fxmlLoader.setController(dockItemBoundary);
                node[i] = (Node) fxmlLoader.load();
//                node[i] = (Node) FXMLLoader.load(getClass().getResource("fxml/dock_item.fxml"));
                dock_item.getChildren().add(node[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * back click
     * @param event  ActionEvent
     * @throws IOException IOException
     */
    @FXML
    public void backButtonClicked(ActionEvent event)  throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("fxml/home_screen.fxml"));
		Scene homeScreenScene = new Scene(root);
        
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        primaryStage.setScene(homeScreenScene);
        primaryStage.show();
	}
    /**
     * back click
     * @param event  ActionEvent
     * @throws IOException IOException
     */
    @FXML
    public void chooseARandomDockButtonClicked(ActionEvent event)  throws IOException
	{
    	Random generator = new Random();
    	ObservableList<Node> dockItems = dock_item.getChildren();
    	
    	int randDock = generator.nextInt();
    	
    	/***
    	 * truyen dock
    	 */
    	Parent root = FXMLLoader.load(getClass().getResource("fxml/bike_list.fxml"));
        Scene bikeListScene = new Scene(root);
        
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        primaryStage.setScene(bikeListScene);
        primaryStage.show();
	}
    
    
}
