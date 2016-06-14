package passenger.controller;

import passenger.model.TSRequest.*;
import passenger.model.MapTemp.*;
// 까먹지 말기
import javafx.fxml.FXML;
// 까먹지 말기
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;


public class TSRequestController {

	@FXML private AnchorPane TSRequest_ANCHOR;			// TSRequest_앵커
	@FXML private ComboBox<Starting_Node> STARTINGNODE_COMBOBOX;		// 출발지_콤보박스
	@FXML private ComboBox<Destination_Node> DESTINATIONNODE_COMBOBOX;	// 도착지_콤보박스
	@FXML private ComboBox<Waiting_Time> WAITINGTIME_COMBOBOX;	// 대기시간_콤보박스
	@FXML private Button REQUEST_BUTTON;						// 요청하기_버튼
	@FXML private Button CANCEL_BUTTON;							// 취소_버튼
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
