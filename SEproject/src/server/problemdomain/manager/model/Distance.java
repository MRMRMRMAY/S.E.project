/*
 * Distance.java
 * it represents distance between spots
 * ex) spot1's distance info
 * 		spot1:-1, spot2:100, spot3:10, spot4:50 ..... -1 means no route
 */

package server.problemdomain.manager.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Distance {
	private HashMap<Spot, Integer> distanceInfo; // spot list
												// spot, distance fair
												// ex) (spot1, 100), (spot2, 200), (spot3, -1)
												// -1 means not connected or distance to itself
	
	public Distance() {
		distanceInfo = new HashMap<Spot, Integer>(); // initiate arraylist
	}
	
	
	public HashMap<Spot, Integer> getDistance() {
		return distanceInfo;
	}

	// add new spot
	public void addSpot(Spot newSpot, int distance)
	{
		distanceInfo.put(newSpot, distance);
	}
	
	// delete spot
	public void deleteSpot(Spot deleteSpot)
	{
		// check spot is exsisted
		if ( distanceInfo.containsKey(deleteSpot) == true )
		{
			distanceInfo.remove(deleteSpot);
		}
	}	
}
