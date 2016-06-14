package server.problemdomain.manager.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import server.problemdomain.manager.MainApp;
import server.problemdomain.manager.model.Person;

public class MoneyController {
	@FXML
	private TextField moneyField;
    private MainApp mainApp;
    private Stage dialogStage;
    private boolean okClicked = false;
	private int money;
    @FXML
    private void initialize() {
    }
	
	
	
	@FXML
    private void handleOk() {
        if (isInputValid()) {
            money = Integer.parseInt(moneyField.getText());
            
            mainApp.setMoney(money);
            System.out.println("money:"+mainApp.getMoney());
            okClicked = true;
            mainApp.showDialog("상수:"+money, "dialog");
            dialogStage.close();
            
        }
    }
	public int getMoney(){
		return money;
	}
    public boolean isOkClicked() {
        return okClicked;
    }
    public boolean isInputValid() {
        String errorMessage = "";

        if (moneyField.getText() == null || moneyField.getText().length() == 0) {
            errorMessage += "No valid money!\n"; 
        }else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(moneyField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n"; 
            }
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
	public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		this.mainApp = mainApp;
	}



	public void setDialogStage(Stage dialogStage) {
		// TODO Auto-generated method stub
		this.dialogStage = dialogStage;
	}
}
