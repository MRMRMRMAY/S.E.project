package C.V;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import C.Main;
import C.M.userLogin;

public class PersonLoginController{


    @FXML
    private PasswordField password;
    @FXML
    private TextField ID;
    private userLogin user;
    private boolean okClicked = false;
    // Reference to the main application.
    private Main mainApp;
    private Stage dialogStage;
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonLoginController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    	//ID.setText(user.getId());
    //    password.setText(user.getPassword());
    	showLoginDetail(null);
       
       
    }
    private void showLoginDetail(userLogin person){
    	
    }
    private void handleOk() {
        if (isInputValid()) {
            user.setId(ID.getText());
            user.setPassword(password.getText());
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

        if (ID.getText() == null || ID.getText().length() == 0) {
            errorMessage += "No valid id!\n";
            System.out.println("fl");
        }
        if (password.getText() == null || password.getText().length() == 0) {
            errorMessage += "No valid password!\n"; 
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            //Dialogs.create()
              //  .title("Invalid Fields")
             //  .masthead("Please correct invalid fields")
              //  .message(errorMessage)
              //  .showError();
            return false;
        }
    }

    public boolean isOkClicked() {
        return okClicked;
    }
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
       // personTable.setItems(mainApp.getPersonData());
    }
}
