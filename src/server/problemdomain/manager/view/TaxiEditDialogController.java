package server.problemdomain.manager.view;



import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private TextField taxiNumberField;
    @FXML
    private TextField cityField;


    private Stage dialogStage;
    private Taxi taxi;
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
    public void setTaxi(Taxi Taxi) {
        this.taxi = Taxi;

        nameField.setText(taxi.getName());
        taxiNumberField.setText(taxi.getTaxiNumber());
        cityField.setText(taxi.getCity());
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
            taxi.setTaxiNumber(taxiNumberField.getText());
            taxi.setCity(cityField.getText());

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

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (taxiNumberField.getText() == null || taxiNumberField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
//        	Dialogs.create()
//		        .title("Invalid Fields")
//		        .masthead("Please correct invalid fields")
//		        .message(errorMessage)
//		        .showError();
            return false;
        }
    }
}