package passenger.controller;

import passenger.model.FareInfo;
import passenger.model.MatchingInfo;

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

public class MatchingInfoController {
	@FXML private Label Passengers_LABEL;		// 동승 인원 정보 표시
	@FXML private Label TaxiInfo_LABEL;			// 택시 정보 표시
	@FXML private Button Matching_BUTTON;		// 매칭 완료 버튼
	@FXML private Button PlateCheck_BUTTON;		// 차량 조회 버튼
	
	MatchingInfo MatchingInfo1 = new MatchingInfo(4, "34자 7853", "010-7853-3786");
	// FareInfo FareInfo1 = new FareInfo();
	
	// 동승 인원 안내
	public void popPassengersInfo (ActionEvent event) throws Exception {
		Passengers_LABEL.setText("동승할 승객을 찾았습니다. \n\n" + MatchingInfo1.getNumber_of_passengers_test() + "명의 승객이 매칭되었습니다.");
//		FareInfo_LABEL.setWrapText(true);
	}
	
	
	// 택시 정보 안내
	public void popTaxiInfo (ActionEvent event) throws Exception {
		TaxiInfo_LABEL.setText("택시의 차량 번호는 \n\n" + MatchingInfo1.getTaxi_plate() + "이며 \n\n\n택시의 연락처는 \n\n" + MatchingInfo1.getTaxi_contact() + "입니다.");
//		FareInfo_LABEL.setWrapText(true);
	}
}
