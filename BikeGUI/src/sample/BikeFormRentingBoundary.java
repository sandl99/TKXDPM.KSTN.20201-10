package sample;

//import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.RentingBikeController;
import entity.Bike;
import entity.Transaction;
import exception.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import log.LogManager;

public class BikeFormRentingBoundary implements Initializable {

    Bike bike;
    Transaction transaction;
    RentingBikeController rentingBikeController;

    @FXML
    private Label type;
    @FXML
    private Label deposit;
    @FXML
    private TextField name;
    @FXML
    private TextField card;

    public BikeFormRentingBoundary(Bike bike, RentingBikeController rentingBikeController) {
        this.bike = bike;
        this.rentingBikeController = rentingBikeController;
        transaction = rentingBikeController.getTransaction();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.type.setText(bike.getTypeString());
        this.deposit.setText(bike.getDeposit() + " VND");
        this.card.setText("118131_group10_2020");
    }

    private void errorDialog(String err) {
        ButtonType loginButtonType = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Alert Dialog");
        dialog.setContentText(err);
        dialog.getDialogPane().getButtonTypes().add(loginButtonType);
        boolean disabled = false; // computed based on content of text fields, for example
        dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
        dialog.showAndWait();
    }
    public void confirmButtonClicked(ActionEvent event)  throws IOException
	{
	    rentingBikeController.setTransaction(transaction, name.getText(), card.getText(), bike);
	    try {
            rentingBikeController.startTransaction(transaction);
            ButtonType loginButtonType = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Alert Dialog");
            dialog.setContentText("Transaction Successfully !");
            dialog.getDialogPane().getButtonTypes().add(loginButtonType);
            boolean disabled = false; // computed based on content of text fields, for example
            dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
            dialog.showAndWait();
        } catch (PaymentException e) {
            LogManager.log.info("Starting Transaction Failed...");
            errorDialog(e.getLocalizedMessage());
        }
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.close();
	}
}