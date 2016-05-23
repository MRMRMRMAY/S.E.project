/*
 * Map.java
 * it represents map, used entire system
 */

package problemdomain.systemdata;

import java.io.Serializable;
import java.util.ArrayList;


/*
 * Serializable - to directly save object  
 * Clonable - to get deep copy
*/
public class Map implements Serializable, Cloneable{
	private ArrayList<Spot> spotList; // spot list
}
