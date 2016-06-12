package server.problemdomain.member;

import java.io.Serializable;

public class Enum implements Serializable {
	public enum TaxiState {
		FREE, DRIVING;
	}
	
	public enum MemberType {
		TAXI, PASSENGER;
	}
}
