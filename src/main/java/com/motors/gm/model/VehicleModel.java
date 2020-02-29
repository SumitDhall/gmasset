package com.motors.gm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("vehicleModel")
public class VehicleModel {
	
	@Id
	private String regNumber;
	
	private String make;
	private String model;
	private String modelVariant;
	private String fuelType;
	private int numberOfDoors;
	private int engineSize;
	private double milage;
	private int annualTax;
	private double co2Emission;
	private String colour;
	private String bodyType;
	private String GearBox;
	private float fuelConsumption;
	private String insuranceGroup;
	private double buyPrice;
	private double salePrice;
	
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getModelVariant() {
		return modelVariant;
	}
	public void setModelVariant(String modelVariant) {
		this.modelVariant = modelVariant;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public int getNumberOfDoors() {
		return numberOfDoors;
	}
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	public int getEngineSize() {
		return engineSize;
	}
	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}
	public double getMilage() {
		return milage;
	}
	public void setMilage(double milage) {
		this.milage = milage;
	}
	public int getAnnualTax() {
		return annualTax;
	}
	public void setAnnualTax(int annualTax) {
		this.annualTax = annualTax;
	}
	public double getCo2Emission() {
		return co2Emission;
	}
	public void setCo2Emission(double co2Emission) {
		this.co2Emission = co2Emission;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public String getGearBox() {
		return GearBox;
	}
	public void setGearBox(String gearBox) {
		GearBox = gearBox;
	}
	public float getFuelConsumption() {
		return fuelConsumption;
	}
	public void setFuelConsumption(float fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	public String getInsuranceGroup() {
		return insuranceGroup;
	}
	public void setInsuranceGroup(String insuranceGroup) {
		this.insuranceGroup = insuranceGroup;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	
}
