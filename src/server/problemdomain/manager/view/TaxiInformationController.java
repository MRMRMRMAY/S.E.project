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
    private TableView<Taxi> TaxiTable;
    @FXML
    private TableColumn<Taxi, String> nameColumn;
    @FXML
    private TableColumn<Taxi, String> cityColumn;
    @FXML
    private TableColumn<Taxi, String> taxiNumberColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label taxiNumberLabel;
    @FXML
    private Label cityLabel;

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
//        cityColumn.setCellValueFactory(
//        		cellData -> cellData.getValue().cityProperty());
        taxiNumberColumn.setCellValueFactory(
        		cellData -> cellData.getValue().taxiNumberProperty());
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
    private void showTaxiDetails(Taxi taxi) {
    	if (taxi != null) {
    		// Fill the labels with info from the Taxi object.
    		nameLabel.setText(taxi.getName());
    		taxiNumberLabel.setText(taxi.getTaxiNumber());
    		cityLabel.setText(taxi.getCity());
    	} else {
    		// Taxi is null, remove all the text.
    		nameLabel.setText("");
    		taxiNumberLabel.setText("");
    		cityLabel.setText("");
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
			// Nothing selected.
		}
	}
	
	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new Taxi.
	 */
	@FXML
	private void handleNewTaxi() {
		Taxi tempTaxi = new Taxi();
		boolean okClicked = mainApp.showTaxiEditDialog(tempTaxi);
		if (okClicked) {
			mainApp.getTaxiData().add(tempTaxi);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected Taxi.
	 */
	@FXML
	private void handleEditTaxi() {
		Taxi selectedTaxi = TaxiTable.getSelectionModel().getSelectedItem();
		if (selectedTaxi != null) {
			boolean okClicked = mainApp.showTaxiEditDialog(selectedTaxi);
			if (okClicked) {
				showTaxiDetails(selectedTaxi);
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