/*
 * MainController.java
 * Login and State
 *
 * wangnan
 * */
package driver.controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.TimerTask;

import driver.model.Place;
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

	Place ti = new Place("경대 북문",7);
	/*Place pla2 = new Place("경대 서문",1);
	Place pla3 = new Place("경대 동문",1);
	Place pla4 = new Place("대구역",1);
	Place pla5 = new Place("home plus",1);
    */

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
			Parent root = FXMLLoader.load(getClass().getResource("/driver/view/Main.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("/driver/view/application.css").toExternalForm());
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
		lblLocation.setText("지금 " + ti.getPlace() + ti.getTime() + "분후 에 도착합니다.");
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
	/*
	class MyTask extends TimerTask 
	{  
		
	    @Override  
	    public void run() 
	    {  
	        System.out.println(ti.getTim());  
	  
	    }  
	}
*/
}