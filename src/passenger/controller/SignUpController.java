﻿package passenger.controller;

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

public class SignUpController implements Initializable{
	@FXML private AnchorPane SignUp_ANCHOR;
	@FXML private TextField ID_TEXTFIELD;
	@FXML private PasswordField Password_PASSWORDFIELD;
	@FXML private TextField NAME_TEXTFIELD;		// 이름_텍스트필드
	@FXML private TextField CONTACT_TEXTFIELD;	// 연락처_텍스트필드
	@FXML private CheckBox AGREE_CHECKBOX;		// 동의_체크박스
	@FXML private Button SIGNUP_BUTTON;			// 회원가입_버튼
	@FXML private Button CANCEL_BUTTON;			// 취소_버튼
    
	private Stage dialogStage;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CANCEL_BUTTON.setOnAction(e->cancelAction(e));
		SIGNUP_BUTTON.setOnAction(e->signUpAction(e));
	}
    
	public void cancelAction(ActionEvent e){
		AnchorPane root = (AnchorPane) CANCEL_BUTTON.getScene().getRoot();
		root.getChildren().remove(SignUp_ANCHOR);
		dialogStage.close();
	}
	
	public void signUpAction(ActionEvent event){
		String passenger_ID = ID_TEXTFIELD.getText();
		String passenger_Password = Password_PASSWORDFIELD.getText();
		String passenger_Name = NAME_TEXTFIELD.getText();			// passenger_이름
		String passenger_Contact = CONTACT_TEXTFIELD.getText();		// passenger_연락처
		 
	    // MySQL path, port: 3306, DB name: ts_member (TS=Taxi Sharing)
		String jdbcUrl = "jdbc:MysSQL57://localhost:3306/ts_member";
		String dbId = "root";
		String dbPw = "aktlwk";	  
		Connection conn = null;
		PreparedStatement pstmt = null;
		  
		String sql = "";
		int num = 0;
		new SignUpController();
		String ID = passenger_ID;
		String Password = passenger_Password;
		String Name = passenger_Name;		// 이름 = passenger_이름
		String Contact = passenger_Contact;	// 연락처 = passenger_연락처
		  
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//DB
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			
			sql = "insert into ts_member values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, ID);
			pstmt.setString(3, Password);
			pstmt.setString(4, Name);
			pstmt.setString(5, Contact);
			pstmt.executeUpdate();
			dialogStage.close();
			}
		catch (Exception e) {
			e.printStackTrace();
			} finally{
				if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
				if(conn!=null) try{conn.close();}catch(SQLException ex){}
			}
			AnchorPane root = (AnchorPane) CANCEL_BUTTON.getScene().getRoot();
			root.getChildren().remove(SignUp_ANCHOR);
			
		}
	

	public void setDialogStage(Stage dialogStage) {
		// TODO Auto-generated method stub
		this.dialogStage = dialogStage;
	}
	
	
}