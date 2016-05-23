/*
 * Location.java
 * it represents location of taxi
 */

package problemdomain.systemdata;

import java.io.Serializable;

/*
 * Serializable - to directly save object  
 * Clonable - to get deep copy
*/
public class Spot implements Serializable, Cloneable {
	private int spotIndex; // index for easy using
	private String spotName; // name for spot it may used at clients
	
	public int getSpotIndex() {
		return spotIndex;
	}
	public String getSpotName() {
		return spotName;
	}
	public void setSpotIndex(int spotIndex) {
		this.spotIndex = spotIndex;
	}
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	
	
}
