package com.foodApp.FoodApp.dto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class FoodProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private String about;
	private String availability;
	private int price;
	
	//@JsonManagedReference
	@ManyToOne
	@JoinColumn
	private Menu menu;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "foodProduct [id=" + id + ", name=" + name + ", type=" + type + ", about=" + about + ", availability="
				+ availability + ", price=" + price + "]";
	}
	public FoodProduct(int id, String name, String type, String about, String availability, int price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.about = about;
		this.availability = availability;
		this.price = price;
	}
	public FoodProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
