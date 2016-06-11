package server.problemdomain.manager.view;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import server.problemdomain.manager.MainApp;

//import org.controlsfx.dialog.Dialogs;

import server.problemdomain.manager.model.*;


/**
 * Dialog to edit details of a person.
 * 
 * @author Marco Jakob
 */
public class PersonEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField numberField;
   // @FXML
   // private TextField statementField;
   // @FXML
   // private TextField placeField;

    private MainApp mainApp;
    private Stage dialogStage;
    private Person person;
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
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        nameField.setText(person.getname());
    //   placeField.setText(person.getplace());
    //    statementField.setText(person.getstatement());
        numberField.setText(person.getNumber());
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
            person.setName(nameField.getText());
//            person.setplace(placeField.getText());
 //           person.setstatement(statementField.getText());
            person.setNumber(numberField.getText());

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
    public void setMainApp(MainApp mainApp){
    	this.mainApp = mainApp;
    }
    public boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (numberField.getText() == null || numberField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
        	mainApp.showDialog("Please correct invalid fields", "Invalid Fields");
            // Show the error message.
/*        	Dialogs.create()
		        .title("Invalid Fields")
		        .masthead("Please correct invalid fields")
		        .message(errorMessage)
		        .showError();*/
            return false;
        }
    }
}