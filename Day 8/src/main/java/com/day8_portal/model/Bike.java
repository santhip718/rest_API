package com.day8_portal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bike")
public class Bike {
	@Id
	@GeneratedValue
	private int bikeId;
	private String regNumber;
	private String owenerName;
	private int year;
	private String bikeName;
	private String modelName;
	
	
	public Bike() {
		super();
	}
	public Bike(int bikeId, String regNumber, String owenerName, int year, String bikeName, String modelName) {
		super();
		this.bikeId = bikeId;
		this.regNumber = regNumber;
		this.owenerName = owenerName;
		this.year = year;
		this.bikeName = bikeName;
		this.modelName = modelName;
	}
	public int getBikeId() {
		return bikeId;
	}
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getOwenerName() {
		return owenerName;
	}
	public void setOwenerName(String owenerName) {
		this.owenerName = owenerName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	
}
