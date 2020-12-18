package sample;

import controller.DockListController;
import controller.RentingBikeController;
import controller.ReturnBikeController;
import entity.*;
import exception.PaymentException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import log.LogManager;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 *
 * @author sanpc
 */
public class RentingDetailBoundary implements Initializable {
    @FXML
    private Label name;
    @FXML
    private Label pin;
    @FXML
    private Label bikeId;
    @FXML
    private Label deposit;
    @FXML
    private Label time;
    @FXML
    private Label barcode;
    @FXML
    private Label total;

    private RentingBikeController rentingBikeController;
    private ReturnBikeController returnBikeController;
    private DockListController dockListController;

//    private
    public RentingDetailBoundary(RentingBikeController rentingBikeController) {
        this.rentingBikeController = rentingBikeController;
        this.dockListController = new DockListController();
    }

    private String getDurationString(int seconds) {

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;
        LogManager.log.info("Time: " + hours + " : " + minutes + " : " + seconds);
        return hours + " : " + minutes + " : " + seconds;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Bike bike = rentingBikeController.getTransaction().getBike();
        User user = rentingBikeController.getTransaction().getUser();
        this.name.setText(user.getName());
        this.pin.setText(bike.getPin() + "%");
        this.bikeId.setText("Bike " + bike.getId());
        this.deposit.setText(bike.getDeposit() + " VND");
        this.time.setText(getDurationString((int) rentingBikeController.getTimeUsing()));
        this.barcode.setText(bike.getBarcode());
        this.total.setText(rentingBikeController.getTotal() + " VND");
    }
    private void alert(String s) {
        ButtonType loginButtonType = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Alert Dialog");
        dialog.setContentText(s);
        dialog.getDialogPane().getButtonTypes().add(loginButtonType);
        boolean disabled = false; // computed based on content of text fields, for example
        dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
        dialog.showAndWait();
    }
    @FXML
    public void onClickReturn (ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert Dialog");
        alert.setContentText("Do you want to return this bike ?");
        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
//        ButtonType cancelButton = new ButtonType("Yes", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okButton, noButton);
        alert.showAndWait().ifPresent(type -> {
            if (type == okButton) {
                LogManager.log.info("Return button YES pressed !");
                if (returnBikeController == null) returnBikeController = new ReturnBikeController();
                try {
                    Dock dock = chooseDockToReturn()
                    returnBikeController.refund(rentingBikeController.getTransaction(), rentingBikeController.getTotal());
                    alert("Return successfully !");
                    Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    primaryStage.close();
                }
                catch (PaymentException e) {
                    alert(e.getMessage());
                }
            } else {

            }
        });
    }

    private Dock chooseDockToReturn(List<Dock> docks) {
        final Dock[] dock = new Dock[1];
        Dock defaultBook = docks.get(0);
        ChoiceDialog<Dock> dialog = new ChoiceDialog<Dock>(defaultBook, docks);

        dialog.setTitle("Choice Dialog");
        dialog.setHeaderText("Select a dock to return bike:");
        dialog.setContentText("Dock:");

        Optional<Dock> result = dialog.showAndWait();
        result.ifPresent(dockSelected -> {
            dock[0] = dockSelected;});
        return dock[0];
    }

}
