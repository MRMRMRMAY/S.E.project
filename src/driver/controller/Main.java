/*
 * Main.java
 * 
 * wangnan
 * */
package driver.controller;
	

import java.io.IOException;
import java.util.List;

import com.sun.javafx.geom.transform.GeneralTransform3D;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import physicalarchitecture.ClientConsole;
import physicalarchitecture.client.ChatClient;
import physicalarchitecture.common.ChatIF;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	// for client
	private Stage primaryStage;
	private ChatClient client;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parameters param = getParameters();
			List<String> str = param.getRaw();
			ClientConsole cc = new ClientConsole();
			try {
//				client = new ChatClient(str.get(0), str.get(1), this);
				client = new ChatClient("localhost", 5555, cc);
			} catch (IOException exception) {
				System.out.println("Error: Can't setup connection!" + " Terminating client.");
				System.exit(1);
			}
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