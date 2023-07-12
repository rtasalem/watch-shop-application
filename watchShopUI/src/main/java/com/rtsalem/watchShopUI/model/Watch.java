package com.rtsalem.watchShopUI.model;

public class Watch {
	
	private int id;
	private String manufacturer;
	private String model;
	private double price;
	private String modelReferenceNumber;
	
	public Watch() {
		super();
	}

	public Watch(String manufacturer, String model, double price, String modelReferenceNumber) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.price = price;
		this.modelReferenceNumber = modelReferenceNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getModelReferenceNumber() {
		return modelReferenceNumber;
	}

	public void setModelReferenceNumber(String modelReferenceNumber) {
		this.modelReferenceNumber = modelReferenceNumber;
	}

}
