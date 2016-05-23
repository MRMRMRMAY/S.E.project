package controller.view;

import java.util.ArrayList;

import org.controlsfx.dialog.Dialogs;

import controller.MainApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import controller.moder.userLogin;
public class LoginController {
	private MainApp main;
	private Stage dialogStage;
	private boolean okCliked = false;
	private TextField id;
	private PasswordField password;
	
//	private userLogin user = new userLogin();
	public LoginController() {
		
	}
	@FXML
	public void initiallize(){
		
	}
	public void setDialogStage(Stage dialogStage){
		this.dialogStage = dialogStage;
	}
	@FXML
	private void handleCancel(){
		dialogStage.close();
	}
	public boolean isOkclicked(){
		return okCliked;
	}
	@FXML
	private void handleOk(){
		boolean pass = false;
		userLogin user = new userLogin(id.getText(),password.getText());
		ArrayList<userLogin> item = user.getBook();
		for(int i = 0; i<item.size();i++){
			userLogin a = item.get(i);
			if(a.getId().equals(user.getId())&&a.getPassword().equals(user.getPassword()))
				pass = true;
		}
		if(pass==false){
			main.showDialog("Please correct invalid fields", "error");
		}
		else{
			okCliked = true;
			dialogStage.close();
		}
	}
}
