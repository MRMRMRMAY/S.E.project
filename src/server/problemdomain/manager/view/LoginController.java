package server.problemdomain.manager.view;

import server.problemdomain.member.Member;
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
	private ArrayList<LoginInformation> loginInformation = new ArrayList<LoginInformation>();
	
//	private userLogin user = new userLogin();
	public LoginController() {
//		loginInformation.add(new LoginInformation("moment","123456"));
		loginInformation.add(new LoginInformation("admin","admin"));
//		loginInformation.add(new LoginInformation("mmmmm","123"));
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
		for(LoginInformation item : loginInformation){
			if(item.getId().equals(id.getText())&&item.getPw().equals(password.getText())){
				return true;
			}
		}
		//return "moment".equals(id.getText())&&"123456".equals(password.getText());
		return false;
	}
	public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		this.main = mainApp;
	}
}
class LoginInformation extends Member{
	public LoginInformation(String id, String pw){
		super.setId(id);
		super.setPw(pw);
	}
}
