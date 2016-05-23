package controller.view;

import controller.moder.DiaLog;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

public class DialogController{
	@FXML
	private Label message;
	private Stage dialog;
	public void setStage(Stage dialog){
		this.dialog = dialog;
	}
	public void setMessage(DiaLog diaLog){
		this.message.setText(diaLog.getMessage());
	}
	public void handOk(){
		dialog.close();
	}
	
}
