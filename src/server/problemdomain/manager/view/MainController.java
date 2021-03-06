package server.problemdomain.manager.view;

import javafx.fxml.FXML;

//import org.controlsfx.dialog.Dialogs;

import server.problemdomain.manager.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import server.problemdomain.manager.MainApp;


public class MainController{
	private MainApp main;
	private Stage dialogStage;
	private boolean okCliked = false;
	private boolean mapCliked = false;
	private MapAdd mapAdd = new MapAdd();
	public MainController() {
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
	private void handleLogin(){
		dialogStage.close();
		main.showLoginStage();
		main.showDialog("Log out", "Log out");
//		boolean okClicked = main.showLoginStage();
/*		if (okClicked == true) {
			main.showDialog("welcome", "pass");
		}*/
	}
	@FXML
	private void handleInfo(){
		main.showPersonOverview();
	}
	@FXML
	private void handleMoney(){
		main.showMoneyview();
	}
	
	@FXML
	private void handleExit(){
		dialogStage.close();
	}
	public void setMainApp(MainApp main){
		this.main = main;
	}
	@FXML
	public void handleMap(){
		
		new MapStart();
	//	main.showMap();
	}
	@FXML
	public void handleTaxi(){
		main.showTaxiOverview();

	}
//	public static void main(String[] args) {
//		launch(args);
//	}
}
