/*
 * Passenger.java
 * class for passenger
 */

package server.problemdomain.member;

import java.io.Serializable;

/*
 * Serializable - to directly save object  
 * Clonable - to get deep copy
*/
public class Passenger extends Member implements Serializable, Cloneable {
	private String name; // name
	private String contactNumber; // phone number
	
	public Passenger() {}

	public Passenger(String name, String number) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.contactNumber = number;
	}
	
	public Passenger(String id, String pw, String name, String number) {
		// TODO Auto-generated constructor stub
		super(id, pw);
		this.name = name;
		this.contactNumber = number;
	}

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
