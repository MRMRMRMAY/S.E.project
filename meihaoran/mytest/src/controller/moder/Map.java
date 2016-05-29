/*
 * Map.java
 * it represents map, used entire system
 */

package controller.moder;

import java.io.Serializable;
import java.util.ArrayList;


/*
 * Serializable - to directly save object  
 * Clonable - to get deep copy
*/
public class Map implements Serializable, Cloneable{
	private ArrayList<Spot> spotList; // spot list
	private ArrayList<Distance> distanceList; // distance list
	public ArrayList<Spot> getSpotList() {
		return spotList;
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
	

}
