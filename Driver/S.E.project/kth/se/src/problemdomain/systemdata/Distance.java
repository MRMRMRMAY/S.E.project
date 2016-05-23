/*
 * Distance.java
 * it represents distance between spots
 */

package problemdomain.systemdata;

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
