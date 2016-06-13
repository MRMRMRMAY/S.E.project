package passenger.controller;

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
	@FXML private Label TaxiInFo_LABEL;			// 택시 정보 표시
	@FXML private Button Matching_BUTTON;		// 매칭 완료 버튼
	
	MatchingInfo MatchingInfo1 = new MatchingInfo(4, "32바 6784", "010-6784-7545");
	
	
}
