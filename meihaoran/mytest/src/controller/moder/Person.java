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
	private final StringProperty phoneNumber;
	private final StringProperty statement;
	private final IntegerProperty place;

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
	public Person(String name, String phoneNumber) {
		this.name = new SimpleStringProperty(name);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		
		// Some initial dummy data, just for convenient testing.
		this.statement = new SimpleStringProperty("some statement");
		this.place = new SimpleIntegerProperty(1234);
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

	public String getphoneNumber() {
		return phoneNumber.get();
	}

	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}
	
	public StringProperty phoneNumberProperty() {
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

	public int getplace() {
		return place.get();
	}

	public void setplace(int place) {
		this.place.set(place);
	}
	
	public IntegerProperty placeProperty() {
		return place;
	}
	
}