package server.problemdomain.manager.view;

import java.util.ArrayList;

//import org.controlsfx.dialog.Dialogs;

import server.problemdomain.manager.model.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import server.problemdomain.manager.MainApp;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
public class LoginController {
	private MainApp main;
	private Stage dialogStage;
	private boolean okCliked = false;
	@FXML
	private TextField id;
	@FXML
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
		/*userLogin user = new userLogin(id.getText(),password.getText());
		ArrayList<userLogin> item = user.getBook();
		for(int i = 0; i<item.size();i++){
			userLogin a = item.get(i);
			if(a.getId().equals(user.getId())&&a.getPassword().equals(user.getPassword()))
				pass = true;
		}*/
		if(isInputvalib()){
			okCliked = true;
			//id.setOpacity(0);
			dialogStage.close();
			main.showMainview();
			main.showDialog("Welcome", "pass");

		}
		else{
			main.showDialog("error", "error");
		}
	}
	private boolean isInputvalib(){
		return "moment".equals(id.getText())&&"123456".equals(password.getText());
	}
	public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		this.main = mainApp;
	}
}
