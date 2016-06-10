/*
 * MatchingResult.java
 * 
 * it contains information about matching result
 * driving route, number of passenger, distance, fare, remain time to arrive at departure of point
*/

package problemdomain.matching;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.effect.Light.Spot;

public class MatchingResult implements Serializable{
	private ArrayList<Spot> drivingRoute; // driving route
	private int numOfPassenger; // numOfPassenger
	private int distance; // distance
	private int fare; // fare for driving
	private int estimatedTimeOfDeparture; // estimated time of departure, sec unit;
	
	
	public MatchingResult() {}
	
	public MatchingResult(MatchingQueueEntry entry)
	{
		this.numOfPassenger = entry.getRequests().size();
	}
	
	// calculate drivingRoute
	
	// calculate distance
	
	// calculate fare
	
	// calculate estimatedTimeOfDeparture
	
	
	public ArrayList<Spot> getDrivingRoute() {
		return drivingRoute;
	}
	public int getNumOfPassenger() {
		return numOfPassenger;
	}
	public int getDistance() {
		return distance;
	}
	public int getFare() {
		return fare;
	}
	public int getEstimatedTimeOfDeparture() {
		return estimatedTimeOfDeparture;
	}
	public void setDrivingRoute(ArrayList<Spot> drivingRoute) {
		this.drivingRoute = drivingRoute;
	}
	public void setNumOfPassenger(int numOfPassenger) {
		this.numOfPassenger = numOfPassenger;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public void setEstimatedTimeOfDeparture(int estimatedTimeOfDeparture) {
		this.estimatedTimeOfDeparture = estimatedTimeOfDeparture;
	}

	
}
