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

import driver.model.PessengerM;
import javafx.event.ActionEvent;
import server.problemdomain.member.*;
import server.problemdomain.matching.*;


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
	private Button lblLoginButton;
	//Login Button

	@FXML
	private Label lblState;
	//Taxi state

	@FXML
	private Button lblButton;
	//State change



/******     Passenger Message               ******/

	@FXML
	private Label lblpassenger;

	@FXML
	private Label lblnum1;

	@FXML
	private Label lblnum2;

	@FXML
	private Label lblnum3;

	@FXML
	private Label lblnum4;

	@FXML
	private Label lblstart;

	@FXML
	private Label lblarrive;

	@FXML
	private Label lbltime;

	@FXML
	private Label lblway;

	@FXML
	private Label lblcost;


	//PessengerM pe = new PessengerM(4, "010-3264-1776", "010-2547-3698",
			//"010-2580-0365", "010-2547-8014", "경대 북문", "대구역", 15, "2->3->1", 6000);


/*******      Passenger Message    end             *******/

	private MatchingResult result;
	private Matching match;

	//Taxi Message
	private Taxi taxi;
	private Taxi taxi1;
	private Taxi taxi2;
	private Taxi taxi3;
	private Taxi taxi4;


	/*
	 * Taxi Driver data
	 * */
	public MainController()
	{
		taxi = new Taxi();
		taxi.setId("user");
		taxi.setPw("pass");
		taxi.setDriverName("Sam");
		taxi.setCarModel("Car1");
		taxi.setContactNumber("0055");

		taxi1 = new Taxi();
		taxi1.setId("wang");
		taxi1.setPw("nan");
		taxi1.setDriverName("Amy");
		taxi1.setCarModel("Car2");
		taxi1.setContactNumber("6894");

		taxi2 = new Taxi();
		taxi2.setId("1234");
		taxi2.setPw("5678");
		taxi2.setDriverName("Ben");
		taxi2.setCarModel("Car3");
		taxi2.setContactNumber("1579");

		taxi3 = new Taxi();
		taxi3.setId("1111");
		taxi3.setPw("3333");
		taxi3.setDriverName("Kim");
		taxi3.setCarModel("Car4");
		taxi3.setContactNumber("7842");

		taxi4 = new Taxi();
		taxi4.setId("2222");
		taxi4.setPw("4444");
		taxi4.setDriverName("Jack");
		taxi4.setCarModel("Car5");
		taxi4.setContactNumber("1874");


		result.getDrivingRoute();
		result.getNumOfPassenger();
		result.getDistance();
		result.getFare();
		match.getFrom();
		match.getTo();
		match.getPassengerList();
		match.getPath();
	}






	/*
	 * Login
	 */
	public void Login(ActionEvent event) throws Exception
	{
		//username and password
		//if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")
				//|| txtUserName.getText().equals("wang") && txtPassword.getText().equals("nan"))

		if(txtUserName.getText().equals(taxi.getId()) && txtPassword.getText().equals(taxi.getPw())
				|| txtUserName.getText().equals(taxi1.getId()) && txtPassword.getText().equals(taxi1.getPw())
				|| txtUserName.getText().equals(taxi2.getId()) && txtPassword.getText().equals(taxi2.getPw())
				|| txtUserName.getText().equals(taxi3.getId()) && txtPassword.getText().equals(taxi3.getPw())
				|| txtUserName.getText().equals(taxi4.getId()) && txtPassword.getText().equals(taxi4.getPw()))
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

			// get a handle to the stage
		    Stage stage = (Stage) lblLoginButton.getScene().getWindow();
		    // do what you have to do
		    stage.close();
		}
		else
		{
			//wrong
			lblStatus.setText("Login Failed");

			// get a handle to the stage
		    Stage stage = (Stage) lblLoginButton.getScene().getWindow();
		    // do what you have to do
		    stage.close();
		}


	}

	/*
	 * State
	 * */

	//waiting state
	public void State1(ActionEvent event)
	{

		lblState.setText("상태 변합니다.지금 운행 대기 상태입니다.");
	}


	//runing state
	public void State2(ActionEvent event)
	{
		lblState.setText("상태 변합니다.지금 운행 중 상태입니다.");



		/*Passenger Message */

		/*이 부분이 있으면 실행이 안된다*/
		lblpassenger.setText(match.getPassengerList()+"");
		lblnum1.setText(result.getNumOfPassenger()+"");
		lblnum2.setText(result.getNumOfPassenger()+"");
		lblnum3.setText(result.getNumOfPassenger()+"");
		lblnum4.setText(result.getNumOfPassenger()+"");
		lblstart.setText(match.getFrom()+"");
		lblarrive.setText(match.getTo()+"");
		lbltime.setText(result.getDistance()+"");
		lblway.setText(result.getDrivingRoute()+"");
		lblcost.setText(result.getFare()+"");

		/*이 부분하면 실행 된다.*/
		/*lblpassenger.setText(pe.getPassenger()+"");
		lblnum1.setText(pe.getNum1());
		lblnum2.setText(pe.getNum2());
		lblnum3.setText(pe.getNum3());
		lblnum4.setText(pe.getNum4());
		lblstart.setText(pe.getStart());
		lblarrive.setText(pe.getArrive());
		lbltime.setText(pe.getTime()+"");
		lblway.setText(pe.getWay());
		lblcost.setText(pe.getCost()+"");*/
	}


	//end state
	public void State3(ActionEvent event)
	{
		lblState.setText("상태 변합니다.지금 운행 종료 상태입니다.");

		// get a handle to the stage
	    Stage stage = (Stage) lblButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}


	/*
	 * Button change
	 * */
	enum RunningState
	{
	    s1,s2,s3
	}

	RunningState sta = RunningState.s1;//next state
	RunningState sta1 = RunningState.s1;//to sever
	private Main main;

	public void State4(ActionEvent event)
	{
		switch(sta)
		{

		//start
		case s1:
			lblButton.setText("출발지 도착");
			lblState.setText("지금 출발지 가고있습니다.");
			sta1= RunningState.s1;//sever
			sta = RunningState.s2;
			break;

		//go to start
		case s2:
			lblButton.setText("목적지 도착");
			lblState.setText("지금 목적지 가고있습니다.");
			sta1= RunningState.s2;//sever
			sta = RunningState.s3;
			break;

		//go to arrive
		case s3:
			lblButton.setText("출발");
			lblState.setText("목적지도착합니다.");
			sta1= RunningState.s3;//sever
			sta = RunningState.s1;
			break;

		}


	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	/*
	 * Location
	 *
	public void Loca(ActionEvent event)
	{


	}*/
}