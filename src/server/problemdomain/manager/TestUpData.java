package server.problemdomain.manager;

import java.util.ArrayList;

import server.problemdomain.member.Passenger;

public class TestUpData {
	private ArrayList<Passenger> passengerData = new ArrayList<Passenger>();
	public TestUpData(ArrayList<Passenger> passengerData){
		this.passengerData = passengerData;
		this.passengerData.add(new Passenger("add1","add1"));
		this.passengerData.add(new Passenger("add2","add2"));
	}
}
