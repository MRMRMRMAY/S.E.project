package passenger.controller;

import java.net.URL;
import java.util.ResourceBundle;

// 테스트용 import javafx.application.Application;
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
	@FXML private AnchorPane SignIn_앵커;	// scene builder에서 StackPane 만들고 수정하자 사인인 사인업 둘 다
	@FXML private TextField ID_텍스트필드;
	@FXML private PasswordField Password_패스워드필드;
	@FXML private Button 로그인_버튼;
	@FXML private Button 취소_버튼;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		로그인_버튼.setOnAction(e->signInAction(e));
	}
    
	
	public void signInAction(ActionEvent event){
		try{
		Parent SignIn = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
		AnchorPane root = (AnchorPane) 로그인_버튼.getScene().getRoot();
		root.getChildren().add(SignIn);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void handleBtnAction(ActionEvent e){
		Platform.exit();
	}
	
	public static void main(String[] args) {
		// 테스트용 launch(args);
	  }
}