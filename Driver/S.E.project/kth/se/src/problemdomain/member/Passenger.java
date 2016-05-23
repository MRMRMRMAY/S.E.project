/*
 * Passenger.java
 * class for passenger
 */

package problemdomain.member;

import java.io.Serializable;

/*
 * Serializable - to directly save object  
 * Clonable - to get deep copy
*/
public class Passenger extends Member implements Serializable, Cloneable {
	private String name; // name
	private String contactNumber; // phone number

	public String getName() {
		return name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}
