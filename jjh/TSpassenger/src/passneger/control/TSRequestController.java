package passneger.control;

import passenger.model.TSRequest.*;
import passenger.model.MapTemp.*;
// 까먹지 말기
import javafx.fxml.FXML;
// 까먹지 말기
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;


public class TSRequestController {

	@FXML private AnchorPane TSRequest_앵커;
	@FXML private ComboBox<Starting_Node> 출발지_콤보박스;
	@FXML private ComboBox<Destination_Node> 도착지_콤보박스;
	@FXML private ComboBox<Waiting_Time> 대기시간_콤보박스;
	@FXML private Button 요청하기_버튼;
	@FXML private Button 취소_버튼;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
