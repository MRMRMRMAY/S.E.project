/*
 * Message.java
 *
 * wangnan
 * */
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Message
{
	//UserMessage
	UserMess userM = new UserMess();

	@FXML
	private Label lblMT;
	//Message tips
	
	@FXML
	private Label lblMC;
	//Message Content
	
	@FXML
	public Button closeButton;
	
	
	/*
	 * Message Tips
	 * */
	public void MessT(ActionEvent event) throws Exception
	{
		//user matching Message 
		lblMT.setText("전화번호 " + userM.getNum1() + "고개님이랑 " + userM.getNum2() + "고개님이\n"
		+ userM.getStart() + "부터  " + userM.getArrive() + "까지 턱시 타고 싶어요." + "\n\n확인 하세요." );
		
		/*
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
		Scene scene = new Scene(root,600,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		*/
	
	}
	
	
	//...
	public void MessC(ActionEvent event)
	{
		/*@FXML
		private void handleCloseButtonAction(ActionEvent event) {*/
		    Stage stage = (Stage) closeButton.getScene().getWindow();
		    stage.close();
		//}
		//((Node)(event.getSource())).getScene().getWindow().hide();


	}


}
