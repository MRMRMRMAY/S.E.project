package passenger.model;

import passenger.model.MapTemp.Starting_Node;
import passenger.model.MapTemp.Destination_Node;

public class TSRequest {

	private Starting_Node starting_node;		// �����
	private Destination_Node destination_node;	// ������
	private Waiting_Time waiting_time;			// ��� �ð�
	private boolean request;					// ��û
	
	
	// �����
	public Starting_Node getStarting_node() {
		return starting_node;
	}
	public void setStarting_node(Starting_Node starting_node) {
		this.starting_node = starting_node;
	}

	// ������
	public Destination_Node getDestination_node() {
		return destination_node;
	}
	public void setDestination_node(Destination_Node destination_node) {
		this.destination_node = destination_node;
	}

	// ��� �ð�
	public Waiting_Time getWaiting_time() {
		return waiting_time;
	}
	public void setWaiting_time(Waiting_Time waiting_time) {
		this.waiting_time = waiting_time;
	}

	// ��û
	public boolean isRequest() {
		return request;
	}
	public void setRequest(boolean request) {
		this.request = request;
	}

	public enum Waiting_Time {
		����, �ʺ�, �ʿ���, ��ʺ�
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
