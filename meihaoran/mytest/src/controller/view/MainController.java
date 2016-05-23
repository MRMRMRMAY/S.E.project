package controller.view;

import javafx.fxml.FXML;

import org.controlsfx.dialog.Dialogs;

import controller.MainApp;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainController{
	private MainApp main;
	private Stage dialogStage;
	private boolean okCliked = false;

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
		
		boolean okClicked = main.showLoginStage();
		if (okClicked) {
	        main.showDialog("welcome", "pass");
		}
	}
	@FXML
	private void handleInfo(){
		
	}
	@FXML
	private void handleExit(){
		dialogStage.close();
	}
	public void setMainApp(MainApp main){
		this.main = main;
	}
//	public static void main(String[] args) {
//		launch(args);
//	}
}
