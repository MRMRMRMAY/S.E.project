package controller;

import java.io.IOException;


import controller.moder.Person;
import controller.view.DialogController;
import controller.view.InfomationController;
import controller.view.LoginController;
import controller.view.MainController;
import controller.view.PersonEditDialogController;
import controller.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Sharing App");
	//	initRootLay();
		showMainview();
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
	public void showMainview(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MainView.fxml"));
			AnchorPane Mainview = (AnchorPane)loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Sharing App");
			dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(Mainview);
	        dialogStage.setScene(scene);
			MainController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMainApp(this);
			dialogStage.show();
//			primaryStage.setScene(scene);
//			primaryStage.show();
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
			loader.setLocation(MainApp.class.getResource("view/Login.fxml"));
			AnchorPane Mainview = (AnchorPane)loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Main login");
			dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(Mainview);
	        dialogStage.setScene(scene);
			LoginController controller = loader.getController();
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
	public ObservableList<Person> getPersonData() {
    	return personData;
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
			controller.setPerson(person);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

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
			upDate();
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
    public ObservableList<Person> getPerdata(){
    	return personData;
    }
    //personData from client
    public void upDate(){
    	
    	personData.setAll(personData);
    }
	public static void main(String[] args) {
		launch(args);
	}
}
