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

	@FXML
	private TextField txtUserName;

	@FXML
	private TextField txtPassword;

	@FXML
	private Label State;

	private String state = "";

	public void Login(ActionEvent event) throws Exception
	{
		if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass"))
		{
			lblStatus.setText("Login Success");

			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else
		{
			lblStatus.setText("Login Failed");
		}
	}

	public void State(ActionEvent event)
	{
		String sta = ((Button)event.getSource()).getText();

		if(sta.equals("운행 대기"))
		{
			State.setText("운행 대기!!");
		}

	}
}
