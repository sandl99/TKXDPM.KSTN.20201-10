
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Group 10
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("sample/fxml/home_screen.fxml"));
		Scene homeScreenScene = new Scene(root);
		primaryStage.setScene(homeScreenScene);

		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}
