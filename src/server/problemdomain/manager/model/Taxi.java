package server.problemdomain.manager.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Taxi {

	private final StringProperty name;
	private final StringProperty city;
	private final StringProperty taxiNumber;


	/**
	 * Default constructor.
	 */
	public Taxi() {
		this(null, null);
	}
	
	/**
	 * Constructor with some initial data.
	 * 
	 * @param name
	 * @param lastName
	 */
	public Taxi(String name, String taxiNumber) {
		this.name = new SimpleStringProperty(name);		
		// Some initial dummy data, just for convenient testing.
		this.taxiNumber = new SimpleStringProperty(taxiNumber);
		this.city = new SimpleStringProperty("some city");
	}
	
	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return name;
	}
	
	

	public String getTaxiNumber() {
		return taxiNumber.get();
	}

	public void setTaxiNumber(String taxiNumber) {
		this.taxiNumber.set(taxiNumber);
	}
	
	public StringProperty taxiNumberProperty() {
		return taxiNumber;
	}

	public String getCity() {
		return city.get();
	}

	public void setCity(String city) {
		this.city.set(city);
	}
	
	public StringProperty cityProperty() {
		return city;
	}


}