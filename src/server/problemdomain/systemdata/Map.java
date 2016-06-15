/*
 * Map.java
 * it represents map, used entire system
 */

package server.problemdomain.systemdata;

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
	public int[][] mapTo2DArray() {
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
			System.out.println("size: " + size);
			
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
				{
					distance.addSpot(spotList.get(j), arrayMap[i][j]); // save distance

				}
				distanceList.add(distance);
				
			}
		}
	}

	public void arrayToMap(int arrayMap[][], String... spotNames ) {
		int size;
		
		if ( arrayMap.length != arrayMap[0].length )
		{
			System.err.println("2D array must be square");
		}
		else
		{
			size = arrayMap.length;
			System.out.println("size: " + size);
			
			spotList = new ArrayList<Spot>(size);
			distanceList = new ArrayList<Distance>(size);
			
			for ( int i = 0; i < size; i++ )
			{
				Spot spot = new Spot();
				spot.setSpotIndex(i);
				spot.setSpotName(spotNames[i]);
				spotList.add(spot);
			}
			
			for ( int i = 0; i < size; i++ )
			{	
				Distance distance = new Distance();
				for ( int j = 0; j < size; j++ )
				{
					distance.addSpot(spotList.get(j), arrayMap[i][j]); // save distance

				}
				distanceList.add(distance);
				
			}
		}
	}

	
	public void setSpotList(ArrayList<Spot> spotList) {
		this.spotList = spotList;
	}

	public ArrayList<Distance> getDistanceList() {
		return distanceList;
	}
	public void setDistanceList(ArrayList<Distance> distanceList) {
		this.distanceList = distanceList;
	}
	public void removeDistanceList(int index){
		this.distanceList.remove(index);
	}
	public void addDistanceList(int index, Distance element){
		if(!distanceList.contains(element))
			this.distanceList.set(index, element);
	}
	public void removeSpot(int index){
		this.spotList.remove(index);
	}
	public void addSpot(int index, Spot element){
		if(!spotList.contains(element))
			this.spotList.set(index, element);
	}



	public ArrayList<Spot> getSpotList() {
		return spotList;
	}
	
	public ArrayList<String> getSpotNameList()
	{
		ArrayList<String> spotNameList = new ArrayList<String>();
		
		for ( Spot spot : getSpotList() )
			spotNameList.add((String) spot.getSpotName());
		
		return spotNameList;
	}

}
