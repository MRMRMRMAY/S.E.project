package passenger.model;

public class MapTemp {

	private Starting_Node starting_node;
	private Destination_Node destination_node;
	
	public enum Starting_Node {
		동대구역, 수성못, 이월드, 복현오거리, 서문시장;
	}
	
	public enum Destination_Node {
		동대구역, 수성못, 이월드, 복현오거리, 서문시장;
	}
	
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


	//
	public MapTemp(Starting_Node sn, Destination_Node dn) {
		this.starting_node = sn;		// sn: starting_node
		this.destination_node = dn;		// dn: destination_node
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
