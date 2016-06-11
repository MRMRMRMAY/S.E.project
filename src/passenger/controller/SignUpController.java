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
	@FXML private AnchorPane SignUp_��Ŀ;
	@FXML private TextField ID_�ؽ�Ʈ�ʵ�;
	@FXML private PasswordField Password_�н������ʵ�;
	@FXML private TextField �̸�_�ؽ�Ʈ�ʵ�;
	@FXML private TextField ����ó_�ؽ�Ʈ�ʵ�;
	@FXML private CheckBox ����_üũ�ڽ�;
	@FXML private Button ȸ������_��ư;
	@FXML private Button ���_��ư;
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		���_��ư.setOnAction(e->cancelAction(e));
		ȸ������_��ư.setOnAction(e->signUpAction(e));
	}
    
	public void cancelAction(ActionEvent e){
		AnchorPane root = (AnchorPane) ���_��ư.getScene().getRoot();
		root.getChildren().remove(SignUp_��Ŀ);
	}
	
	public void signUpAction(ActionEvent event){
		String passenger_ID = ID_�ؽ�Ʈ�ʵ�.getText();
		String passenger_Password = Password_�н������ʵ�.getText();
		String passenger_�̸� = �̸�_�ؽ�Ʈ�ʵ�.getText();
		String passenger_����ó = ����ó_�ؽ�Ʈ�ʵ�.getText();
		 
	    // MySQL ���� ���, �⺻ ��Ʈ: 3306, DB �̸�: TS_member TS(Taxi Sharing)
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
		String �̸� = passenger_�̸�;
		String ����ó = passenger_����ó;
		  
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//DB ����
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			
			sql = "insert into ts_member values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, ID);
			pstmt.setString(3, Password);
			pstmt.setString(4, �̸�);
			pstmt.setString(5, ����ó);
			pstmt.executeUpdate();
			}
		catch (Exception e) {
			e.printStackTrace();
			} finally{
				if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
				if(conn!=null) try{conn.close();}catch(SQLException ex){}
			}
			AnchorPane root = (AnchorPane) ���_��ư.getScene().getRoot();
			root.getChildren().remove(SignUp_��Ŀ);
			}
	
	
}