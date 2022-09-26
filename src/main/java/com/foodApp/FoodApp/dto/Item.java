package com.foodApp.FoodApp.dto;

import javax.persistence.*;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String name;
	private String type;
	private int quantity;
	private double price;
	
	//@JsonBackReference
	@ManyToOne
	@JoinColumn
	private FoodOrder foodOrder;
	
	public Item(int Id, String name, String type, int quantity, double price, FoodOrder foodOrder) {
		super();
		this.Id = Id;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.foodOrder = foodOrder;
	}
	public FoodOrder getFoodOrder() {
		return foodOrder;
	}
	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
