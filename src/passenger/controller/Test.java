package passenger.controller;

import passenger.model.TSRequest;
import passenger.view.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class Test implements Initializable{

	@FXML private AnchorPane TSRequest_ANCHOR;					// TSRequest_앵커
	@FXML private ComboBox<String> STARTINGNODE_COMBOBOX;		// 출발지_콤보박스
	@FXML private ComboBox<String> DESTINATIONNODE_COMBOBOX;	// 도착지_콤보박스
	@FXML private ComboBox<String> WAITINGTIME_COMBOBOX;		// 대기시간_콤보박스
	@FXML private Label SELECTEDSTARTINGNODE_LABEL;				// 선택된 출발지_레이블
	@FXML private Label SELECTEDDESTINATIONNODE_LABEL;			// 선택된 도착지_레이블
	//@FXML private ImageView CHECK_ImageVIEW;					// 체크_이미지뷰
	@FXML private Button REQUEST_BUTTON;						// 요청하기_버튼
	@FXML private Button CANCEL_BUTTON;							// 취소_버튼
	@FXML private ImageView NodeImage;							// 체크_이미지
	@FXML private ImageView CheckImage1;
	@FXML private ImageView CheckImage2;
		
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		assert CheckImage2 != null : "fx:id=\"CheckImage2\" was not injected: check your FXML file 'TSRequest.fxml'.";
		
		assert DESTINATIONNODE_COMBOBOX != null : "fx:id=\"DESTINATIONNODE_COMBOBOX\" was not injected: check your FXML file 'TSRequest.fxml'.";

		// bind the selected STARTINGNODE_COMBOBOX label to the selected Starting Node in the combo box.
		
		SELECTEDDESTINATIONNODE_LABEL.textProperty().bind(DESTINATIONNODE_COMBOBOX.getSelectionModel().selectedItemProperty());

				
		
		
		DESTINATIONNODE_COMBOBOX.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			
			@Override 
			public void changed(ObservableValue<? extends String> selected, String oldDESTINATIONNODE, String newDESTINATIONNODE) {
				if (oldDESTINATIONNODE != null) {
					switch(oldDESTINATIONNODE) {
					case "동대구역": CheckImage2.setVisible(false); break;
					case "수성못": CheckImage2.setVisible(false); break;
					case "이월드": CheckImage2.setVisible(false); break;
					case "복현오거리": CheckImage2.setVisible(false); break;
					case "서문시장": CheckImage2.setVisible(false); break;
					}
				}
			
				if (newDESTINATIONNODE != null) {
					switch(newDESTINATIONNODE) {
					case "동대구역": CheckImage2.setVisible(true); break;
					case "수성못": CheckImage2.setVisible(true); break;
					case "이월드": CheckImage2.setVisible(true); break;
					case "복현오거리": CheckImage2.setVisible(true); break; 
					case "서문시장": CheckImage2.setVisible(true); break;
					}
				}  
			}
		});	
	}
	
}