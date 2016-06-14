/*
 * Main.java
 * 
 * wangnan
 * */
package driver.controller;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	// for client
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Open Login.fxml
			/*
			 * Parent root =
			 * FXMLLoader.load(getClass().getResource("/driver/view/Login.fxml")
			 * ); Scene scene = new Scene(root,600,400);
			 * scene.getStylesheets().add(getClass().getResource(
			 * "/driver/view/application.css").toExternalForm());
			 * primaryStage.setScene(scene); primaryStage.show();
			 */
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Taxi");

			showMain();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showMain() {
		/*
		 * Parent root =
		 * FXMLLoader.load(getClass().getResource("/driver/view/Login.fxml"));
		 * Scene scene = new Scene(root,600,400);
		 * scene.getStylesheets().add(getClass().getResource(
		 * "/driver/view/application.css").toExternalForm());
		 * primaryStage.setScene(scene); primaryStage.show();
		 */
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/driver/view/Login.fxml"));
		AnchorPane main;
		try {
			main = (AnchorPane) loader.load();

			Scene scene = new Scene(main);
			scene.getStylesheets().add(getClass().getResource("/driver/view/application.css").toExternalForm());

			MainController controller = loader.getController();
			controller.setMain(this);

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}