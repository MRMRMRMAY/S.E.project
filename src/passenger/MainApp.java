package passenger;

import java.io.IOException;
import java.util.ArrayList;

import server.problemdomain.manager.model.*;
import server.problemdomain.manager.view.*;
import server.problemdomain.member.Passenger;
import server.problemdomain.member.Taxi;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import passenger.controller.MatchingInfoController;
import passenger.controller.SignInController;
import passenger.controller.SignUpController;
import passenger.controller.TSRequestController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ArrayList<Passenger> passengerData = new ArrayList<Passenger>();
	private ArrayList<Taxi> serverTaxiData = new ArrayList<Taxi>();
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Sharing App");
	//	initRootLay();
		//showMainview();
		showLoginStage();
	}
	public MainApp(){
	
	}
	
	public void initRootLay(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			
			rootLayout = (BorderPane)loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public Stage getPrimayStage(){
		return primaryStage;
	}
	public boolean showLoginStage(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SignIn.fxml"));
			AnchorPane Mainview = (AnchorPane)loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Main login");
			dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(Mainview);
	        dialogStage.setScene(scene);
			SignInController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMainApp(this);
			dialogStage.show();
			return controller.isOkclicked();
		}
		catch(IOException e){
			e.printStackTrace();
			return false;
		}

	}
	public void showDialog(String message,String title){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Dialogs.fxml"));
			AnchorPane dialog = (AnchorPane)loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle(title);
			dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(dialog);
	        dialogStage.setScene(scene);
			DialogController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setMessage(message);
			dialogStage.show();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void showSignUpPage() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SignUp.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Sign Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			SignUpController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			// Show the dialog and wait until the user closes it
			dialogStage.show();

			//return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			//return false;
		}
	}
    public void showTSrequestPage() {
		try{
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/TSRequest.fxml"));
			AnchorPane Mainview = (AnchorPane)loader.load();
//			upDate();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("TSR");
			dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(Mainview);
	        dialogStage.setScene(scene);
			TSRequestController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMainApp(this);
//			controller.setInformation();
			dialogStage.showAndWait();
			
//			primaryStage.setScene(scene);
//			primaryStage.show();
		}
		catch(IOException e){
			e.printStackTrace();
		}
    }
    public void showMatchingInfo() {
        try {
            // Load person overview.
			//controller.setDialogStage(dialogStage);
			
			
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/passenger/view/MatchingInfo.fxml"));
            AnchorPane taxiView = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("MatchingInfo View");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(taxiView);
            dialogStage.setScene(scene);
            // Set person overview into the center of root layout.
            
            // Give the controller access to the main app.
            MatchingInfoController controller = loader.getController();
            controller.setMainApp(this);
            dialogStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
	public static void main(String[] args) {
		launch(args);
	}
}
