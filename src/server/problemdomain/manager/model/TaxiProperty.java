package server.problemdomain.manager.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TaxiProperty {

	private final StringProperty name;
	private final StringProperty carModel;
	private final StringProperty contactNumber;


	/**
	 * Default constructor.
	 */
	public TaxiProperty() {
		this(null, null,null);
	}
	/**
	 * Constructor with some initial data.
	 * 
	 * @param name
	 * @param lastName
	 */
	public TaxiProperty(String name,String carModel, String contactNumber) {
		this.name = new SimpleStringProperty(name);		
		// Some initial dummy data, just for convenient testing.
		this.contactNumber = new SimpleStringProperty(contactNumber);
		this.carModel = new SimpleStringProperty(carModel);
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
	
	

	public String getContactNumber() {
		return contactNumber.get();
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber.set(contactNumber);
	}
	
	public StringProperty contactNumberProperty() {
		return contactNumber;
	}

	public String getCarModel() {
		return carModel.get();
	}

	public void setCarModel(String carModel) {
		this.carModel.set(carModel);
	}
	
	public StringProperty carModelProperty() {
		return carModel;
	}


}