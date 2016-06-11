package server.problemdomain.manager.model;

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
//	private final IntegerProperty phoneNumber;
	private final StringProperty number;
//	private final StringProperty place;

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
	public Person(String name, String number) {
		this.name = new SimpleStringProperty(name);
		//this.phoneNumber = new SimpleIntegerProperty(123123);
		
		// Some initial dummy data, just for convenient testing.
		this.number = new SimpleStringProperty(number);
		//this.place = new SimpleStringProperty("12134541354");
	}
	
	public String getname() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return name;
	}

	public String getNumber() {
		return number.get();
	}

	public void setNumber(String number) {
		this.number.set(number);
	}
	
	public StringProperty numberProperty() {
		return number;
	}
	
}