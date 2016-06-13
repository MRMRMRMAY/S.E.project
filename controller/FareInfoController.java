package passenger.controller;

import passenger.model.FareInfo;

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
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

public class FareInfoController implements Initializable {
	
	@FXML private Label FareInfo_LABEL;		// 요금 정보 표시
	
	FareInfo FareInfo1 = new FareInfo();
	
	public void popFareInfo (ActionEvent event) throws Exception {
		FareInfo_LABEL.setText("운행 요금은 \n\n총 " + FareInfo1.getTotal_fare_test() + "원이며 \n\n개인당 " + FareInfo1.getCaptication_fare_test() + "원씩 \n\n부담되겠습니다.");
//		FareInfo_LABEL.setWrapText(true);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
