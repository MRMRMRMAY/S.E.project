/*
 * MessageTest.java
 * Main Message
 * 
 * wangnan
 * */

package driver.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MessageTest extends Application 
{
	
	@Override
	public void start(Stage primaryStage) 
	{
		try {
			//Open MessageTest.fxml
			Parent root = FXMLLoader.load(getClass().getResource("/driver/view/MessageTest.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("/driver/view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
