/* Member.java
 * super class of system member
*/
package passenger.model;

import java.io.Serializable;

/*
 * Serializable - to directly save object  
 * Clonable - to get deep copy
*/
public class Member implements Serializable, Cloneable {
	private String id; // id
	private String pw; // password

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
