package passenger.controller;

import java.net.URL;
import java.util.ResourceBundle;

// �׽�Ʈ�� import javafx.application.Application;
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
	@FXML private AnchorPane SignIn_��Ŀ;	// scene builder���� StackPane ����� �������� ������ ���ξ� �� ��
	@FXML private TextField ID_�ؽ�Ʈ�ʵ�;
	@FXML private PasswordField Password_�н������ʵ�;
	@FXML private Button �α���_��ư;
	@FXML private Button ���_��ư;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		�α���_��ư.setOnAction(e->signInAction(e));
	}
    
	
	public void signInAction(ActionEvent event){
		try{
		Parent SignIn = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
		AnchorPane root = (AnchorPane) �α���_��ư.getScene().getRoot();
		root.getChildren().add(SignIn);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void handleBtnAction(ActionEvent e){
		Platform.exit();
	}
	
	public static void main(String[] args) {
		// �׽�Ʈ�� launch(args);
	  }
}