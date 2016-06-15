package server.problemdomain.manager;

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
import physicalarchitecture.Server;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
public class MainApp extends Application {
	private Server sv;
	
	private MapStart map;
	private boolean loginFlag = false;
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	private ObservableList<TaxiProperty> taxiData = FXCollections.observableArrayList();
	
	private ArrayList<Passenger> passengerData = new ArrayList<Passenger>();
	private ArrayList<Taxi> serverTaxiData = new ArrayList<Taxi>();
	private int money;
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Sharing App");
	//	initRootLay();
		//showMainview();
		showLoginStage();
	}
	public MainApp(){
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt("6666"); // Get port from command line
		} catch (Throwable t) {
			port = 6666; // Set port to 5555
		}

		sv = new Server(port);

		try {
			
			sv.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
		System.out.println("d");
		/* init*/
		//accept server's data
		//passengerData =
		/*test*/
		//MenegerTestServer test = new MenegerTestServer(1);
		passengerData = sv.getPassengerList();
		passengerToPerson();
		serverTaxiData = sv.getTaxi();
		serverTaxiToTaxi();
//		passengerData.add(new Passenger("Hans", "Muster"));
//		passengerData.add(new Passenger("Ruth", "Mueller"));
//		passengerData.add(new Passenger("Heinz", "Kurz"));
//		passengerData.add(new Passenger("Cornelia", "Meier"));
//		passengerData.add(new Passenger("Werner", "Meyer"));
//		passengerData.add(new Passenger("Lydia", "Kunz"));
//		passengerData.add(new Passenger("Anna", "Best"));
//		passengerData.add(new Passenger("Stefan", "Meier"));
//		passengerData.add(new Passenger("Martin", "Mueller"));
		//passengerToPerson();
		/*taxiData.add(new TaxiProperty("Hans","Hans", "1232"));
        taxiData.add(new TaxiProperty("Ruth","Hans", "123333"));
        taxiData.add(new TaxiProperty("Heinz","Hans", "232"));
        taxiData.add(new TaxiProperty("Cornelia","Hans", "123311"));
        taxiData.add(new TaxiProperty("Werner","Hans", "123322"));
        taxiData.add(new TaxiProperty("Lydia","Hans", "12332"));
        taxiData.add(new TaxiProperty("Anna", "Hans","123213"));
        taxiData.add(new TaxiProperty("Stefan","Hans", "123231"));
        taxiData.add(new TaxiProperty("Martin", "Hans","1232"));*/
//		serverTaxiData.add(new Taxi("Hans","Hans", "1232"));
//		serverTaxiData.add(new Taxi("Ruth","Hans", "123333"));
//		serverTaxiData.add(new Taxi("Heinz","Hans", "232"));
//		serverTaxiData.add(new Taxi("Cornelia","Hans", "123311"));
//		serverTaxiData.add(new Taxi("Werner","Hans", "123322"));
//		serverTaxiData.add(new Taxi("Lydia","Hans", "12332"));
//		serverTaxiData.add(new Taxi("Anna", "Hans","123213"));
//		serverTaxiData.add(new Taxi("Stefan","Hans", "123231"));
//		serverTaxiData.add(new Taxi("Martin", "Hans","1232"));
//        serverTaxiToTaxi();
	}
	
	public void personToPassenger(){
		if(!passengerData.isEmpty())
			passengerData.clear();
		for(Person person : personData){
			passengerData.add(new Passenger(person.getname(),person.getNumber()));
		}
	}
	
	
	public void passengerToPerson(){
		if(!personData.isEmpty())
			personData.clear();
		for(Passenger passenger : passengerData){
			personData.add(new Person(passenger.getName(),passenger.getContactNumber()));
		}
	}
	
	public void testUpData(){
		TestUpData test = new TestUpData(passengerData);
		passengerToPerson();
	}
	
	
	public void taxiToServerTaxi(){
		if(!serverTaxiData.isEmpty())
			serverTaxiData.clear();
		
		for(TaxiProperty taxi:taxiData){
			serverTaxiData.add(new Taxi(taxi.getName(),taxi.getCarModel(),taxi.getContactNumber()));
			System.out.println("name : " + taxi.getName()+ "contact number :" +taxi.getContactNumber() + "car model : " + taxi.getCarModel());
		}
		System.out.println();
	}
	
	public void serverTaxiToTaxi(){
		if(!taxiData.isEmpty())
			taxiData.clear();
		for(Taxi taxi:serverTaxiData){
			taxiData.add(new TaxiProperty(taxi.getDriverName(),taxi.getCarModel(),taxi.getContactNumber()));
			
		}
	}
	
	/*taxi information test updata */
	public void taxiTestUpData(){
		
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
	public ObservableList<TaxiProperty> getTaxiData() {
    	return taxiData;
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
	public void setPerdata(){
		ObservableList<Person> test = null;
		personData = test;
	}
	public void showMap(){
		map = new MapStart(sv);
	}
	public MapStart getMap(){
		return map;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Server getSv() {
		return sv;
	}
}
