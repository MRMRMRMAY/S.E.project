package controller.moder;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {

	private final StringProperty name;
	private final IntegerProperty phoneNumber;
	private final StringProperty statement;
	private final StringProperty place;

	/**
	 * Default constructor.
	 */
	public Person() {
		this(null, null);
	}
	
	/**
	 * Constructor with some initial data.
	 * 
	 * @param name
	 * @param phoneNumber
	 */
	public Person(String name, String statement) {
		this.name = new SimpleStringProperty(name);
		this.phoneNumber = new SimpleIntegerProperty(123123);
		
		// Some initial dummy data, just for convenient testing.
		this.statement = new SimpleStringProperty(statement);
		this.place = new SimpleStringProperty("12134541354");
	}
	
	public String getname() {
		return name.get();
	}

	public void setname(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return name;
	}

	public int getphoneNumber() {
		return phoneNumber.get();
	}

	public void setphoneNumber(int phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}
	
	public IntegerProperty phoneNumberProperty() {
		return phoneNumber;
	}

	public String getstatement() {
		return statement.get();
	}

	public void setstatement(String statement) {
		this.statement.set(statement);
	}
	
	public StringProperty statementProperty() {
		return statement;
	}

	public String getplace() {
		return place.get();
	}

	public void setplace(String place) {
		this.place.set(place);
	}
	
	public StringProperty placeProperty() {
		return place;
	}
	
}