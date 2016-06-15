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
import passenger.controller.SignInController;
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
	
	public boolean showPersonEditDialog(Person person) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			PersonEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			// Show the dialog and wait until the user closes it
			dialogStage.show();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
    public void showPersonOverview() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/InformationView.fxml"));
			AnchorPane Mainview = (AnchorPane)loader.load();
//			upDate();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Information");
			dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(Mainview);
	        dialogStage.setScene(scene);
			PersonOverviewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMainApp(this);
//			controller.setInformation();
			dialogStage.show();
//			primaryStage.setScene(scene);
//			primaryStage.show();
		}
		catch(IOException e){
			e.printStackTrace();
		}
    }
    public void showTaxiOverview() {
        try {
            // Load person overview.
			//controller.setDialogStage(dialogStage);
			
			
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TaxiInformation.fxml"));
            AnchorPane taxiView = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Taxi View");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(taxiView);
            dialogStage.setScene(scene);
            // Set person overview into the center of root layout.
            
            // Give the controller access to the main app.
            TaxiInformationController controller = loader.getController();
            controller.setMainApp(this);
            dialogStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean showTaxiEditDialog(TaxiProperty taxi) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/TaxiEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			TaxiEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setTaxi(taxi);
			controller.setMainApp(this);
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
    public void showMoneyview() {
        try {
            // Load person overview.
			//controller.setDialogStage(dialogStage);
			
			
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MoneyView.fxml"));
            AnchorPane moneyView = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Money View");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(moneyView);
            dialogStage.setScene(scene);
            // Set person overview into the center of root layout.
            
            // Give the controller access to the main app.
            MoneyController controller = loader.getController();
            controller.setMainApp(this);
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
	public static void main(String[] args) {
		launch(args);
	}
}
