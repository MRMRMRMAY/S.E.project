/*
 * Map.java
 * it represents map, used entire system
 */

package problemdomain.systemdata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Serializable - to directly save object  
 * Clonable - to get deep copy
*/
public class Map implements Serializable, Cloneable {
	private ArrayList<Spot> spotList; // spot list
	private ArrayList<Distance> distanceList; // distance list

	// return map data by 2d array format
	int[][] mapTo2DArray() {
		int[][] arrayMap = null;

		if (spotList.size() != distanceList.size())
			System.err.println("spotList and distanceList size is unequal");
		else {
			arrayMap = new int[spotList.size()][spotList.size()];
			
			for (int i = 0; i < spotList.size(); i++) {
				HashMap<Spot, Integer> dist = distanceList.get(i).getDistance(); // get row info
				for (int j = 0; j < spotList.size(); j++)
					arrayMap[i][j] = dist.get(spotList.get(j));
			}
		}
		return arrayMap;
	}

	public void arrayToMap(int arrayMap[][]) {
		int size;
		
		if ( arrayMap.length != arrayMap[0].length )
		{
			System.err.println("2D array must be square");
		}
		else
		{
			size = arrayMap.length;
			
			spotList = new ArrayList<Spot>(size);
			distanceList = new ArrayList<Distance>(size);
			
			for ( int i = 0; i < size; i++ )
			{
				Spot spot = new Spot();
				spot.setSpotIndex(i);
				spotList.add(spot);
			}
			
			for ( int i = 0; i < size; i++ )
			{	
				Distance distance = new Distance();
				for ( int j = 0; j < size; j++ )
					distance.addSpot(spotList.get(j), arrayMap[i][j]); // save distance
			}
			// spot에 대한 정보는 나중에 넣기로하고 구조만 만들자
		}
	}

	public ArrayList<Spot> getSpotList() {
		return spotList;
	}

	public ArrayList<Distance> getDistanceList() {
		return distanceList;
	}

}
