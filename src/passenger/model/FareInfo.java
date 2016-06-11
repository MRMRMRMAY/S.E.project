package passenger.model;

public class FareInfo {
	
	private int lead_time;				// 도착지까지 가는데 걸린 시간
	private int elt_fare;				// 시간당 요금
	private int number_of_passengers;	// 동승 인원
	private int total_fare;				// 총 요금
	private int captitation_fare;		// 개별 요금
	
	
	// 도착지까지 가는데 걸린 시간
	public int getLead_time() {
		return lead_time;
	}
	public void setLead_time(int lead_time) {
		this.lead_time = lead_time;
	}
	
	// 시간당 요금
	public int getElt_fare() {
		return elt_fare;
	}
	public void setElt_fare(int elt_fare) {
		this.elt_fare = elt_fare;
	}

	// 동승 인원
	public int getNumber_of_passengers() {
		return number_of_passengers;
	}
	public void setNumber_of_passengers(int number_of_passengers) {
		this.number_of_passengers = number_of_passengers;
	}

	// 총 요금
	public int getTotal_fare() {
		return total_fare;
	}
	public void setTotal_fare() {
		this.total_fare = 2800 + lead_time/elt_fare;
	}

	// 개별 요금
	public int getCaptitation_fare() {
		return captitation_fare;
	}
	public void setCaptitation_fare() {
		this.captitation_fare = total_fare/number_of_passengers;
	}


	//
	public FareInfo() {
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
