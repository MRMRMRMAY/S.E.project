package passenger.controller;

import passenger.model.MapTemp.Destination_Node;
import passenger.model.MapTemp.Starting_Node;
import passenger.model.TSRequest.Waiting_Time;

import java.net.URL;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;


public class TSRequestController implements Initializable{

	@FXML private AnchorPane TSRequest_ANCHOR;							// TSRequest_앵커
	@FXML private ComboBox<Starting_Node> STARTINGNODE_COMBOBOX;		// 출발지_콤보박스
	@FXML private ComboBox<Destination_Node> DESTINATIONNODE_COMBOBOX;	// 도착지_콤보박스
	@FXML private ComboBox<Waiting_Time> WAITINGTIME_COMBOBOX;			// 대기시간_콤보박스
	@FXML private Button REQUEST_BUTTON;								// 요청하기_버튼
	@FXML private Button CANCEL_BUTTON;									// 취소_버튼
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CANCEL_BUTTON.setOnAction(e->cancelAction(e));
		REQUEST_BUTTON.setOnAction(e->requestAction(e));
	}
	
	public void cancelAction(ActionEvent e){
		AnchorPane root = (AnchorPane) CANCEL_BUTTON.getScene().getRoot();
		root.getChildren().remove(TSRequest_ANCHOR);
	}
	
	public void requestAction(ActionEvent event){
		
	}
	
	public void handleBtnAction(ActionEvent e){
		Platform.exit();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
