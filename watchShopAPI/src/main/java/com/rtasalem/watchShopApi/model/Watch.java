package com.rtasalem.watchShopApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Watch {
	
	@Id
	@SequenceGenerator(name = "WATCH_ID_GEN", sequenceName = "WATCH_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WATCH_ID_GEN")
	private int id;
	
	@NotBlank(message = "Watch manufacturer must not be left blank")
	@Size(min = 2, max = 100, message = "Watch manufacturer must be longer than 2 characters and less than 100 characters")
	private String manufacturer;
	
	@NotBlank(message = "Watch model must not be left blank")
	@Size(min = 2, max = 100, message = "Watch model must be longer than 2 characters and less than 100")
	private String model;
	
	@DecimalMin(value = "1", message = "Watch price must be more than £1.00")
	private double price;
	
	@NotBlank
	@Size(min = 2, max = 300, message = "Watch model reference number must be longer than 2 characters and less than 300 characters")
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
