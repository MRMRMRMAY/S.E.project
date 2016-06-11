package passenger.model;

public class FareInfo {
	
	private int lead_time;				// ���������� ���µ� �ɸ� �ð�
	private int elt_fare;				// �ð��� ���
	private int number_of_passengers;	// ���� �ο�
	private int total_fare;				// �� ���
	private int captitation_fare;		// ���� ���
	
	
	// ���������� ���µ� �ɸ� �ð�
	public int getLead_time() {
		return lead_time;
	}
	public void setLead_time(int lead_time) {
		this.lead_time = lead_time;
	}
	
	// �ð��� ���
	public int getElt_fare() {
		return elt_fare;
	}
	public void setElt_fare(int elt_fare) {
		this.elt_fare = elt_fare;
	}

	// ���� �ο�
	public int getNumber_of_passengers() {
		return number_of_passengers;
	}
	public void setNumber_of_passengers(int number_of_passengers) {
		this.number_of_passengers = number_of_passengers;
	}

	// �� ���
	public int getTotal_fare() {
		return total_fare;
	}
	public void setTotal_fare() {
		this.total_fare = 2800 + lead_time/elt_fare;
	}

	// ���� ���
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
