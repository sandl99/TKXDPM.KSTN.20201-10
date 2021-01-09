package sample;

import controller.BarcodeController;
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
 * @author Group 10
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
    private BarcodeController barcodeController;

//    private

    /**
     * Constructor with {@link RentingBikeController}
     * @param rentingBikeController RentingBikeController
     */
    public RentingDetailBoundary(RentingBikeController rentingBikeController) {
        this.rentingBikeController = rentingBikeController;
        this.dockListController = new DockListController();
        this.barcodeController = new BarcodeController();
    }

    /**
     * Convert second to string
     * @param seconds int
     * @return String
     */
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
        this.pin.setText("95%");
        this.bikeId.setText("Bike " + bike.getId());
        this.deposit.setText(bike.getDeposit() + " VND");
        this.time.setText(getDurationString((int) rentingBikeController.getTimeUsing()));
        this.barcode.setText(bike.getBarcode());
        this.total.setText(rentingBikeController.getTotal(rentingBikeController.getTimeUsing()) + " VND");
    }

    /**
     * pop up
     * @param s String
     */
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
    /**
     * return click
     * @param event  ActionEvent
     * @throws IOException IOException
     */

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
                    Label label = new Label();
                    Bike bike = rentingBikeController.getTransaction().getBike();
                    rentingBikeController.setDockInfoController(bike.getDockId());

                    Dock dock = chooseDockToReturn(this.dockListController.getDocks());
                    showInputTextDialog(label);
                    System.out.println(label.getText());
                    String str1 = barcodeController.requestBarcodeStr(label.getText());
                    if (!bike.getBarcode().equals(str1)) {
                        alert("Bike not match or barcode not found !");
                    } else {
                        returnBikeController.refund(rentingBikeController.getTransaction(), rentingBikeController.getTotal(rentingBikeController.getTimeUsing()), dock);
                        alert("Return successfully !");
                        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        primaryStage.close();
                    }
                }
                catch (PaymentException e) {
                    alert(e.getMessage());
                }
            } else {

            }
        });
    }

    /**
     * pop up choose dock for return
     * @param docks a {@link List} of {@link Dock}
     * @return a Dock
     */
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

    private void showInputTextDialog(Label label) {
//        final String[] name = new String[1];
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setTitle("Barcode");
        dialog.setHeaderText("Enter barcode:");
        dialog.setContentText("Barcode:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name1 -> {
            label.setText(name1);
        });
//        return name[0];
    }

}
