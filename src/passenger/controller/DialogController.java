package passenger.controller;

//import controller.model.DiaLog;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

public class DialogController{
	@FXML
	private Label message;
	private Stage dialog;
	public DialogController(){
		
	}
	@FXML
	public void initiallize(){
		
	}
	public void setStage(Stage dialog){
		this.dialog = dialog;
	}
	public void setMessage(String message){
		this.message.setText(message);
	}
	public void handOk(){
		dialog.close();
	}
	
}
