/**
 * Sample Skeleton for 'bike_list.fxml' Controller Class
 */

package sample;

import controller.BarcodeController;
import controller.DockInfoController;
import controller.RentingBikeController;
import entity.Bike;
import entity.Transaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Dock view (Bike List)
 * @author Group 10
 */


public class BikeListBoundary implements Initializable {
    @FXML
    private VBox normalBikes;
    @FXML
    private VBox electricBikes;
    @FXML
    private VBox tandemBikes;

    private RentingBikeController rentingBikeController;
    private DockInfoController dockInfoController;
    private BarcodeController barcodeController;
    Transaction transaction;

    /**
     * Constructor with {@link DockInfoController}
     * @param dockInfoController DockInfoController
     */
    public BikeListBoundary(DockInfoController dockInfoController) {
        this.dockInfoController = dockInfoController;
        this.rentingBikeController = new RentingBikeController(dockInfoController);
        this.barcodeController = new BarcodeController(dockInfoController);
        transaction = Transaction.getTransaction();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < 3; i++) {
            List<Bike> bikes = dockInfoController.getBikesByType(i);
            Node[] node = new Node[bikes.size()];
            for (int j = 0; j < node.length; j++) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/bike_item.fxml"));
//                    System.out.println(bikes.get(j).toString());
                    BikeItemBoundary bikeItemBoundary = new BikeItemBoundary(bikes.get(j), dockInfoController.getDock());
                    fxmlLoader.setController(bikeItemBoundary);

                    node[j] = (Node) fxmlLoader.load();
                    if (i == 0) {
                        normalBikes.getChildren().add(node[j]);
                    } else if (i == 1) {
                        electricBikes.getChildren().add(node[j]);
                    } else {
                        tandemBikes.getChildren().add(node[j]);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//
//        for (int i = 0; i < node.length; i++) {
//            try {
//                node[i] = (Node) FXMLLoader.load(getClass().getResource("fxml/bike_item.fxml"));
//                listView.getItems().add(node[i]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    /**
     * popup for barcode
     * @param label text
     */
    private void showInputTextDialog(Label label) {
//        Label label;
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setTitle("Barcode");
        dialog.setHeaderText("Enter barcode:");
        dialog.setContentText("Barcode:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> {
            label.setText(name);
        });
    }

    /**
     * Rent a bike, if choose one, alert box confirm yes/no, if no choice, alert announ
     * @param event ActionEvent
     * @throws IOException
     */
    public void rentABikeButtonClicked(ActionEvent event)  throws IOException
    {
//        Transaction transaction = rentingBikeController.getTransaction();
        if (transaction.getStatus() == 0) {
//        if (false) {
            Label label = new Label();
            this.showInputTextDialog(label);
            String barcode = label.getText();
            Bike bike = barcodeController.requestBarcode(barcode);

            if (bike == null) {
                ButtonType loginButtonType = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
                Dialog<String> dialog = new Dialog<>();
                dialog.setTitle("Alert Dialog");
                dialog.setContentText("Bike not found !");
                dialog.getDialogPane().getButtonTypes().add(loginButtonType);
                boolean disabled = false; // computed based on content of text fields, for example
                dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
                dialog.showAndWait();
            } else {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/bike_form_renting.fxml"));
                BikeFormRentingBoundary bikeFormRentingBoundary = new BikeFormRentingBoundary(bike, rentingBikeController);
                fxmlLoader.setController(bikeFormRentingBoundary);
                Parent root = fxmlLoader.load();

                Scene bikeRentForm = new Scene(root);

                Stage newStage = new Stage();
                newStage.setScene(bikeRentForm);
                newStage.show();
            }
            System.out.println(barcode);

        } else {
            ButtonType loginButtonType = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Alert Dialog");
            dialog.setContentText("You are having a transaction !");
            dialog.getDialogPane().getButtonTypes().add(loginButtonType);
            boolean disabled = false; // computed based on content of text fields, for example
            dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
            dialog.showAndWait();
        }
    }

    /**
     * back click
     * @param event  ActionEvent
     * @throws IOException IOException
     */
    public void backButtonClicked(ActionEvent event)  throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/dock_list.fxml"));
        Scene dockListScene = new Scene(root);

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(dockListScene);
        primaryStage.show();
    }
}