package com.foodApp.FoodApp.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class FoodOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private boolean status;
	private String orderCreatetime;
	private String orderDeliverytime;
	private String customerName;
	private int contactNumber;

	private int totalPrice;

	@JsonBackReference
	@ManyToOne
	@JoinColumn()
	private User user;

	//@JsonManagedReference
	@OneToMany(mappedBy = "foodOrder", cascade = CascadeType.ALL)
	List<Item> items;

	public FoodOrder(int id, boolean status, String orderCreatetime, String orderDeliverytime, String customerName, int contactNumber, int totalPrice, User user, List<Item> items) {
		this.id = id;
		this.status = status;
		this.orderCreatetime = orderCreatetime;
		this.orderDeliverytime = orderDeliverytime;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.totalPrice = totalPrice;
		this.user = user;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getOrderCreatetime() {
		return orderCreatetime;
	}

	public void setOrderCreatetime(String orderCreatetime) {
		this.orderCreatetime = orderCreatetime;
	}

	public String getOrderDeliverytime() {
		return orderDeliverytime;
	}

	public void setOrderDeliverytime(String orderDeliverytime) {
		this.orderDeliverytime = orderDeliverytime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public FoodOrder() {
	}


}