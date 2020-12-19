package sample;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.RentingBikeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import log.LogManager;

/**
 *
 * @author san.dl170111
 */

public class HomeScreenBoundary implements  Initializable {
	@FXML
	private Button view_dock_list;
	@FXML
	private Button view_renting_bike;

	private RentingBikeController rentingBikeController = new RentingBikeController();

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void viewDockListButtonClicked(ActionEvent event)  throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("fxml/dock_list.fxml"));
        Scene dockListScene = new Scene(root);
        
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        primaryStage.setScene(dockListScene);
        primaryStage.show();
	}
	@FXML
	public void viewRentingBikeButtonClicked(ActionEvent event)  throws IOException
	{
		if (rentingBikeController.getTransaction().getStatus() == 0) {
			ButtonType loginButtonType = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
			Dialog<String> dialog = new Dialog<>();
			dialog.setTitle("Alert Dialog");
			dialog.setContentText("No transaction!");
			dialog.getDialogPane().getButtonTypes().add(loginButtonType);
			boolean disabled = false; // computed based on content of text fields, for example
			dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
			dialog.showAndWait();
			LogManager.log.info("No transaction...");
		} else {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/renting_detail.fxml"));
			RentingDetailBoundary rentingDetailBoundary = new RentingDetailBoundary(rentingBikeController);
			fxmlLoader.setController(rentingDetailBoundary);
			Parent root = fxmlLoader.load();
			Scene rentingDetailScene = new Scene(root);
			Stage newStage = new Stage();
			newStage.setScene(rentingDetailScene);
			newStage.show();
		}
	}
	@FXML
	public void test() {
		String java = new String("J01 Java Tutorial for Beginners");
		String csharp = new String("C01 CSharp Tutoral for Beginners");
		String python = new String("P01 Python for Beginners");

		String defaultBook = csharp;

		ChoiceDialog<String> dialog = new ChoiceDialog<String>(defaultBook, java, csharp, python);

		dialog.setTitle("o7planning");
		dialog.setHeaderText("Select a Book:");
		dialog.setContentText("Book:");

		Optional<String> result = dialog.showAndWait();

	}
}