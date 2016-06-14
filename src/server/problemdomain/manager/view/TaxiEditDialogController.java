package server.problemdomain.manager.view;



import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import server.problemdomain.manager.MainApp;

//import org.controlsfx.dialog.Dialogs;

import server.problemdomain.manager.model.*;

/**
 * Dialog to edit details of a taxi.
 * 
 * @author Marco Jakob
 */
public class TaxiEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField contactNumberField;
    @FXML
    private TextField carModelField;
    
    private MainApp mainApp;
    private Stage dialogStage;
    private TaxiProperty taxi;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the Taxi to be edited in the dialog.
     * 
     * @param Taxi
     */
    public void setTaxi(TaxiProperty Taxi) {
        this.taxi = Taxi;

        nameField.setText(taxi.getName());
        contactNumberField.setText(taxi.getContactNumber());
        carModelField.setText(taxi.getCarModel());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            taxi.setName(nameField.getText());
            taxi.setContactNumber(contactNumberField.getText());
            taxi.setCarModel(carModelField.getText());

            okClicked = true;
           
            dialogStage.close();
           
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    public void setMainApp(MainApp mainApp){
    	this.mainApp = mainApp;
    }
    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid  name!\n"; 
        }
        if (contactNumberField.getText() == null || contactNumberField.getText().length() == 0) {
            errorMessage += "No valid contact number!\n"; 
        }

        if (carModelField.getText() == null || carModelField.getText().length() == 0) {
            errorMessage += "No valid carModel!\n"; 
        }else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(contactNumberField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n"; 
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
        	mainApp.showDialog(errorMessage+"Please correct invalid fields", "Invalid Fels");
//        	Dialogs.create()
//		        .title("Invalid Fields")
//		        .masthead("Please correct invalid fields")
//		        .message(errorMessage)
//		        .showError();
            return false;
        }
    }
}