/*
 * Taxi.java
 * class for taxi
 */
package server.problemdomain.member;

import java.io.Serializable;

/*
 * Serializable - to directly save object  
 * Clonable - to get deep copy
*/
public class Taxi extends Member implements Serializable, Cloneable {
	private String driverName; // driver name
	private String carModel; // car model
	private String contactNumber; // phone number

	public Taxi() {}
	
	public Taxi(String name, String carModel, String contactNumber) {
		// TODO Auto-generated constructor stub
		this.driverName = name;
		this.carModel = carModel;
		this.contactNumber = contactNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getCarModel() {
		return carModel;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}
