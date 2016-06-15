package passenger.controller;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

//import org.controlsfx.dialog.Dialogs;

import server.problemdomain.manager.model.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import passenger.MainApp;
import passenger.model.Member;
import passenger.model.Passenger;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
public class SignInController {
	private MainApp main;
	private Stage dialogStage;
	private boolean okCliked = false;
	@FXML
	private TextField id;
	@FXML
	private PasswordField password;
	private ArrayList<LoginInformation> loginInformation = new ArrayList<LoginInformation>();
	ReadTestFile read;
//	private userLogin user = new userLogin();
	public SignInController() {
		
		read = new ReadTestFile();
		
		loginInformation = read.getLoginInformation();
		for(LoginInformation item : loginInformation){
			System.out.printf("%s %s %s %s \n", item.getId(), item.getPassword(), item.getName(),item.getpassenger_contact());
		}
		/*loginInformation.add(new LoginInformation("moment","123456"));
		loginInformation.add(new LoginInformation("aaaaa","aaaaa"));
		loginInformation.add(new LoginInformation("mmmmm","123"));*/
		
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
			main.showTSrequestPage();
			

		}
		else{
			main.showDialog("error", "error");
		}
	}
	private boolean isInputvalib(){
		for(LoginInformation item : loginInformation){
			if(item.getId().equals(id.getText())&&item.getPassword().equals(password.getText())){
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
class LoginInformation extends Passenger{
	
	public LoginInformation(String id, String pw,String name,String number){
		super(id,pw,name,number);
	}
}

class ReadTestFile{
	
	private Scanner input;
	private ArrayList<LoginInformation> loginInformation = new ArrayList<LoginInformation>();
	
	public ReadTestFile(){
		openFile();
		readRecords();
		closeFile();
	}
	public void openFile(){
		try{
			input = new Scanner(Paths.get("information.txt"));
			
		}
		catch(IOException ioException){
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}
	public void readRecords(){
		System.out.printf("%-10s%-12s%-12s%10s%n","Account","First Name","Last Name","Balance");
		try{
			while(input.hasNext()){
				//System.out.printf("%-10d%-12s%-12s%10.2f%n",input.nextInt(),input.next(),input.next(),input.nextDouble());
				loginInformation.add(new LoginInformation(input.next(),input.next(),input.next(),input.next()));
			}
		}
		catch(NoSuchElementException elementException){
			System.err.println("File improperly formed. Terminating.");
		}
		catch(IllegalStateException stateException){
			System.err.println("Error reading from file. Terminating.");
		}
	}
	public void closeFile(){
		if(input != null){
			input.close();
		}
	}
	public ArrayList<LoginInformation> getLoginInformation() {
		return loginInformation;
	}
	public void setLoginInformation(ArrayList<LoginInformation> loginInformation) {
		this.loginInformation = loginInformation;
	}
}

