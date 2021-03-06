/*
 * Main.java
 *
 *
 */


package C;
import java.io.IOException;
import java.util.Scanner;
import C.M.Person;
import C.M.userLogin;
import C.V.PersonLoginController;
import C.V.PersonOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Main extends Application {
	
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    private Scanner input = new Scanner(System.in);
    /**
     * Constructor
     */
    public Main() {
        //  Add some sample data
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    // ... THE REST OF THE CLASS ...
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

      //  showPersonOverview();
        
        showLogin();
        
        
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("V/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showLogin(){
    	try {
    	  FXMLLoader loader = new FXMLLoader();
    	  
          loader.setLocation(Main.class.getResource("V/login.fxml"));
          AnchorPane login = (AnchorPane) loader.load();
          rootLayout.setCenter(login);
        
          System.out.println("login");
          //rootLayout.setCenter(person);
          PersonLoginController controller = loader.getController();
          //controller.setMainApp(this);
       } catch (IOException e) {
	   e.printStackTrace();
	   }
    }
    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
//        try {
//            // Load person overview.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Main.class.getResource("V/login.fxml"));
//            AnchorPane personOverview = (AnchorPane) loader.load();
//
//            // Set person overview into the center of root layout.
//            rootLayout.setCenter(personOverview);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
            try {
                // Load person overview.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("V/PersonOverview.fxml"));
                AnchorPane personOverview = (AnchorPane) loader.load();

                // Set person overview into the center of root layout.
                rootLayout.setCenter(personOverview);

                // Give the controller access to the main app.
                PersonOverviewController controller = loader.getController();
                controller.setMainApp(this);
             //   Parent root = FXMLLoader.load(getClass().getResource("PersonOverview"));
              //  new Scene(root,320,200);

            } catch (IOException e) { 
                e.printStackTrace();
            }
       
    }
    

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public boolean showPersonEditDialog(userLogin person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("V/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            PersonLoginController controller = loader.getController();
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


    public static void main(String[] args) {
        launch(args);
    }
}