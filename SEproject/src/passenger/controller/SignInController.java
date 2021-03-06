package passenger.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


//TEST import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignInController implements Initializable{
	@FXML private AnchorPane SignIn_ANCHOR;
	@FXML private TextField ID_TEXTFIELD;
	@FXML private PasswordField Password_PASSWORDFIELD;
	@FXML private Button SIGNIN_BUTTON;	// 로그인_버튼
	@FXML private Button CANCEL_BUTTON;	// 취소_버튼
	@FXML private Button GOSIGNUPPAGE_BUTTON;	// 회원가입페이지로_버튼
	// 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SIGNIN_BUTTON.setOnAction(e->signInAction(e));
	}
    
	
	public void signInAction(ActionEvent event){
		String passenger_ID = ID_TEXTFIELD.getText();
		String passenger_Password = Password_PASSWORDFIELD.getText();
		
		// MySQL path, port: 3306, DB name: ts_member (TS=Taxi Sharing)
		String jdbcUrl = "jdbc:mysql://localhost:3306/ts_member";
		String dbId = "root";
		String dbPw = "tsts";	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = ""; 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// DB 
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);	     
			
			sql = "select id,password from ts_member_passenger where id = ? and pwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, passenger_ID);
			pstmt.setString(2, passenger_Password);
			rs = pstmt.executeQuery(); 
			if(rs.next()){			     
			if(rs.getString("id").equals(passenger_ID) && rs.getString("password").equals(passenger_Password)){
			Parent TSRequest = FXMLLoader.load(getClass().getResource("TSRequest.fxml"));
			AnchorPane root = (AnchorPane) SIGNIN_BUTTON.getScene().getRoot();
			root.getChildren().add(TSRequest);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			} finally {
			if(pstmt!=null) 
				try {
					pstmt.close();
					} catch (SQLException ex) { }
				}
			if(conn!=null) try {
				conn.close();
				} catch (SQLException ex) { }
			}
	
	public void handleBtnAction(ActionEvent e){
		Platform.exit();
	}
	
	public static void main(String[] args) {
		// for test.. launch(args);
	  }
}