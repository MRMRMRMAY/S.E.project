package passenger.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class SignUpController implements Initializable{
	@FXML private AnchorPane SignUp_앵커;
	@FXML private TextField ID_텍스트필드;
	@FXML private PasswordField Password_패스워드필드;
	@FXML private TextField 이름_텍스트필드;
	@FXML private TextField 연락처_텍스트필드;
	@FXML private CheckBox 동의_체크박스;
	@FXML private Button 회원가입_버튼;
	@FXML private Button 취소_버튼;
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		취소_버튼.setOnAction(e->cancelAction(e));
		회원가입_버튼.setOnAction(e->signUpAction(e));
	}
    
	public void cancelAction(ActionEvent e){
		AnchorPane root = (AnchorPane) 취소_버튼.getScene().getRoot();
		root.getChildren().remove(SignUp_앵커);
	}
	
	public void signUpAction(ActionEvent event){
		String passenger_ID = ID_텍스트필드.getText();
		String passenger_Password = Password_패스워드필드.getText();
		String passenger_이름 = 이름_텍스트필드.getText();
		String passenger_연락처 = 연락처_텍스트필드.getText();
		 
	    // MySQL 접속 경로, 기본 포트: 3306, DB 이름: TS_member TS(Taxi Sharing)
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
		String 이름 = passenger_이름;
		String 연락처 = passenger_연락처;
		  
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//DB 연결
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			
			sql = "insert into ts_member values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, ID);
			pstmt.setString(3, Password);
			pstmt.setString(4, 이름);
			pstmt.setString(5, 연락처);
			pstmt.executeUpdate();
			}
		catch (Exception e) {
			e.printStackTrace();
			} finally{
				if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
				if(conn!=null) try{conn.close();}catch(SQLException ex){}
			}
			AnchorPane root = (AnchorPane) 취소_버튼.getScene().getRoot();
			root.getChildren().remove(SignUp_앵커);
			}
	
	
}