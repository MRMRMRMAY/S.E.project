/*
 * Matching.java
 * it contains informations for matching
*/
package server.problemdomain.matching;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import server.problemdomain.member.Passenger;
import server.problemdomain.member.Taxi;
import server.problemdomain.systemdata.Spot;


/*
 * 6.11 
 * for simplicity we may not control matching data......
 */
public class Matching implements Serializable {
	private ArrayList<Passenger> passengerList; // passenger list for matching
	private Taxi taxi;
	private Spot from; // point of departure for matching
	private Spot to; // destination for matching
	private ArrayList<Spot> path; // shortest path for mathcing
	private MatchingStatus status; // status for mathcing
	
	public enum MatchingStatus {
		/*
		 * moving - move to point of departure
		 * driving - carry passengers and drive to destination
		 * complete - run is finished
		*/
		moving, driving, complete;
	}
	
	

	// add passenger
	public void addPassenger(Passenger passenger) {
		passengerList.add(passenger);
	}

	public ArrayList<Passenger> getPassengerList() {
		return passengerList;
	}

	public Taxi getTaxi() {
		return taxi;
	}

	public Spot getFrom() {
		return from;
	}

	public Spot getTo() {
		return to;
	}

	public void setPassengerList(ArrayList<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

	public void setFrom(Spot from) {
		this.from = from;
	}

	public void setTo(Spot to) {
		this.to = to;
	}

	public void setPath(ArrayList<Spot> path) {
		this.path = path;
	}

	public ArrayList<Spot> getPath() {
		return path;
	}

	public MatchingStatus getStatus() {
		return status;
	}

	public void setStatus(MatchingStatus status) {
		this.status = status;
	}
}
