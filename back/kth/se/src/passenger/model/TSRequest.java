package passenger.model;

import passenger.model.MapTemp.Starting_Node;
import passenger.model.MapTemp.Destination_Node;

public class TSRequest {

	private Starting_Node starting_node;		// 출발지
	private Destination_Node destination_node;	// 도착지
	private Waiting_Time waiting_time;			// 대기 시간
	private boolean request;					// 요청
	
	
	// 출발지
	public Starting_Node getStarting_node() {
		return starting_node;
	}
	public void setStarting_node(Starting_Node starting_node) {
		this.starting_node = starting_node;
	}

	// 도착지
	public Destination_Node getDestination_node() {
		return destination_node;
	}
	public void setDestination_node(Destination_Node destination_node) {
		this.destination_node = destination_node;
	}

	// 대기 시간
	public Waiting_Time getWaiting_time() {
		return waiting_time;
	}
	public void setWaiting_time(Waiting_Time waiting_time) {
		this.waiting_time = waiting_time;
	}

	// 요청
	public boolean isRequest() {
		return request;
	}
	public void setRequest(boolean request) {
		this.request = request;
	}

	public enum Waiting_Time {
		오분, 십분, 십오분, 삼십분
	}
	
	
	//
	public TSRequest (Starting_Node sn, Destination_Node dn, Waiting_Time wt, boolean r) {
		this.starting_node = sn;
		this.destination_node = dn;
		this.waiting_time = wt;
		this.request = r;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
