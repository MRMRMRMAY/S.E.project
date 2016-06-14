package passenger.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import passenger.view.*;

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
import javafx.scene.image.Image;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;


public class TSRequestPage extends Application {

	@Override
	public void start(Stage primaryStage)throws IOException {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/passenger/view/TSRequest.fxml"));
			Scene scene = new Scene(root);
			AnchorPane layout = FXMLLoader.load(
				      new URL(TSRequestPage.class.getResource("/passenger/view/TSRequest.fxml").toExternalForm())
				    );
			primaryStage.setScene(new Scene(layout));
			primaryStage.show();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
