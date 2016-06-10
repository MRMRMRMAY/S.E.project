/*
 * MainController.java
 * Login and State
 * 
 * wangnan
 * */
package application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.event.ActionEvent;


public class MainController
{
	
	@FXML
	private Label lblStatus;
	//Login status

	@FXML
	private TextField txtUserName;
	//Login username
	
	@FXML
	private TextField txtPassword;
	//Login password
	
	@FXML
	private Label lblState;
	//Taxi state
	
	@FXML
	private Label lblLocation;
	//Taxi Location
	
	//private String state = "";

	/*
	 * Login
	 */
	public void Login(ActionEvent event) throws Exception
	{
		//username and password
		if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass"))
		{
			//right
			lblStatus.setText("Login Success");

			/*
			 * Open Main.fxml
			 * Main.fxml is Taxi states
			 * */
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else
		{
			//wrong
			lblStatus.setText("Login Failed");
		}
	}

	/*
	 * State
	 * */
	
	//waiting state
	public void State1(ActionEvent event)
	{
		//String value = ((Button)event.getSource()).getText();

		//mystate.setMystate(mystate.getMystate());
		lblState.setText("상태 변합니다.지금 운행 대기 상태입니다.");

	}
	
	//runing state
	public void State2(ActionEvent event)
	{	
		lblState.setText("상태 변합니다.지금 운행 중 상태입니다.");
		lblLocation.setText("지금 가고 있는중...");
	}
	
	//end state
	public void State3(ActionEvent event)
	{
		lblState.setText("상태 변합니다.지금 운행 종료 상태입니다.");
		lblLocation.setText("지금 도착한다.");
	}
	
	/*
	 * Location
	 * */
	public void Loca(ActionEvent event)
	{
		
	}

}