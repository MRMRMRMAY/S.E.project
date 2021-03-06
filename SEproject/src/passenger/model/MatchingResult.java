﻿package passenger.model;

public class MatchingResult {

	private int number_of_passengers;	// 동승 인원
	private String taxi_plate;			// 승객이 볼 정보
	private String taxi_contact;		// 승객이 볼 정보
	
	
	// 동승 인원
	public int getNumber_of_passengers() {
		return number_of_passengers;
	}
	public void setNumber_of_passengers(int number_of_passengers) {
		this.number_of_passengers = number_of_passengers;
	}

	// 차량 번호
	public String getTaxi_plate() {
		return taxi_plate;
	}
	public void setTaxi_plate(String taxi_plate) {
		this.taxi_plate = taxi_plate;
	}

	// 택시 연락처
	public String getTaxi_contact() {
		return taxi_contact;
	}
	public void setTaxi_contact(String taxi_contact) {
		this.taxi_contact = taxi_contact;
	}

	//
	public MatchingResult (int nop, String tp, String tc) {
		this.number_of_passengers = nop;
		this.taxi_plate = tp;
		this.taxi_contact = tc;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
