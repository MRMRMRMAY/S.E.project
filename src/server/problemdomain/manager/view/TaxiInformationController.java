package server.problemdomain.manager.view;



import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import server.problemdomain.manager.MainApp;

//import org.controlsfx.dialog.Dialogs;

import server.problemdomain.manager.model.*;


public class TaxiInformationController {
    @FXML
    private TableView<TaxiProperty> TaxiTable;
    @FXML
    private TableColumn<TaxiProperty, String> nameColumn;
    @FXML
    private TableColumn<TaxiProperty, String> carModelColumn;
    @FXML
    private TableColumn<TaxiProperty, String> contactNumberColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label contactNumberLabel;
    @FXML
    private Label carModelLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public TaxiInformationController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Initialize the Taxi table with the two columns.
        nameColumn.setCellValueFactory(
        		cellData -> cellData.getValue().nameProperty());
//        carModelColumn.setCellValueFactory(
//        		cellData -> cellData.getValue().carModelProperty());
        contactNumberColumn.setCellValueFactory(
        		cellData -> cellData.getValue().contactNumberProperty());
        // Clear Taxi details.
        showTaxiDetails(null);

        // Listen for selection changes and show the Taxi details when changed.
		TaxiTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showTaxiDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        TaxiTable.setItems(mainApp.getTaxiData());
    }
    
    /**
     * Fills all text fields to show details about the Taxi.
     * If the specified Taxi is null, all text fields are cleared.
     * 
     * @param Taxi the Taxi or null
     */
    private void showTaxiDetails(TaxiProperty taxi) {
    	if (taxi != null) {
    		// Fill the labels with info from the Taxi object.
    		nameLabel.setText(taxi.getName());
    		contactNumberLabel.setText(taxi.getContactNumber());
    		carModelLabel.setText(taxi.getCarModel());
    	} else {
    		// Taxi is null, remove all the text.
    		nameLabel.setText("");
    		contactNumberLabel.setText("");
    		carModelLabel.setText("");
    	}
    }

	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeleteTaxi() {
		int selectedIndex = TaxiTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			TaxiTable.getItems().remove(selectedIndex);
		} else {
			mainApp.showDialog("Please select a Taxi in the table", "No selection");
			
		}
		//mainApp.getTaxiData().remove(selectedIndex-1);
		mainApp.taxiToServerTaxi();
	}
	
	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new Taxi.
	 */
	@FXML
	private void handleNewTaxi() {
		TaxiProperty tempTaxi = new TaxiProperty();
		boolean okClicked = mainApp.showTaxiEditDialog(tempTaxi);
		if (okClicked) {
			mainApp.getTaxiData().add(tempTaxi);
			mainApp.taxiToServerTaxi();
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected Taxi.
	 */
	@FXML
	private void handleEditTaxi() {
		TaxiProperty selectedTaxi = TaxiTable.getSelectionModel().getSelectedItem();
		if (selectedTaxi != null) {
			boolean okClicked = mainApp.showTaxiEditDialog(selectedTaxi);
			if (okClicked) {
				showTaxiDetails(selectedTaxi);
				mainApp.taxiToServerTaxi();
			}

		} else {
			// Nothing selected.
//			Dialogs.create()
//				.title("No Selection")
//				.masthead("No Taxi Selected")
//				.message("Please select a Taxi in the table.")
//				.showWarning();
			mainApp.showDialog("Please select a Taxi in the table", "No selection");
		}
	}
}