package controller.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.ArrayList;

import org.controlsfx.dialog.Dialogs;

import controller.MainApp;
import controller.moder.Person;


public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> statementColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label phoneNumberLabel;
    @FXML
    private Label statementLabel;
    @FXML
    private Label placeLabel;

    // Reference to the main application.
    private MainApp mainApp;
    private Stage dialogStage;
    private ArrayList<Person>information;
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    public ArrayList<Person> getInformation() {
		return information;
	}

	public void setInformation(ArrayList<Person> information) {
		this.information = information;
	}
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Initialize the person table with the two columns.
        nameColumn.setCellValueFactory(
        		cellData -> cellData.getValue().nameProperty());
        statementColumn.setCellValueFactory(
        		cellData -> cellData.getValue().statementProperty());
        
        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
		personTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showPersonDetails(newValue));
    }
    public void setInformation(Person person){
    	
    }
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param person the person or null
     */
    private void showPersonDetails(Person person) {
    	if (person != null) {
    		// Fill the labels with info from the person object.
    		nameLabel.setText(person.getname());
    		phoneNumberLabel.setText(person.getphoneNumber());
    		statementLabel.setText(person.getstatement());
    		placeLabel.setText(Integer.toString(person.getplace()));
    	} else {
    		// Person is null, remove all the text.
    		nameLabel.setText("");
    		phoneNumberLabel.setText("");
    		statementLabel.setText("");
    		placeLabel.setText("");
    	}
    }

	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
		int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			personTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
//			Dialogs.create()
//		        .title("No Selection")
//		        .masthead("No Person Selected")
//		        .message("Please select a person in the table.")
//		        .showWarning();
		}
	}
	
	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewPerson() {
		Person tempPerson = new Person();
		boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
		if (okClicked) {
			mainApp.getPersonData().add(tempPerson);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleUpdate() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
			if (okClicked) {
				showPersonDetails(selectedPerson);
			}

		} else {
			// Nothing selected.
//			Dialogs.create()
//				.title("No Selection")
//				.masthead("No Person Selected")
//				.message("Please select a person in the table.")
//				.showWarning();
		}
	}

	public void setDialogStage(Stage dialogStage) {
		// TODO Auto-generated method stub
		this.dialogStage = dialogStage;
	}
}