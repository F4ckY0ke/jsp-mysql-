package entity;

import java.sql.Date;

public class Notebook {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private Double price;
	private Date date;
	private String brand;
	private String configuration;
	private String purpose;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	private int durable;
	private String location;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getConfiguration() {
		return configuration;
	}
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getDurable() {
		return durable;
	}
	public void setDurable(int durable) {
		this.durable = durable;
	}
	public String getLocationString() {
		return locationString;
	}
	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}
	private String locationString;
	public String getName() {
		return name;
	}
	public void setName(String string) {
		this.name = string;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
