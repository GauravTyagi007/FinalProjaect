package com.foodApp.FoodApp.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class FoodOrder {
	
	@Id
	private int id;
	private String status;
	private Date orderCreatetime;
	private Date orderDeliverytime;
	private String customerName;
	private int contactNumber;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn()
	private User user;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderCreatetime() {
		return orderCreatetime;
	}
	public void setOrderCreatetime(Date orderCreatetime) {
		this.orderCreatetime = orderCreatetime;
	}
	public Date getOrderDeliverytime() {
		return orderDeliverytime;
	}
	public void setOrderDeliverytime(Date orderDeliverytime) {
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
	public FoodOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodOrder(int id, String status, Date orderCreatetime, Date orderDeliverytime, String customerName,
			int contactNumber, User user) {
		super();
		this.id = id;
		this.status = status;
		this.orderCreatetime = orderCreatetime;
		this.orderDeliverytime = orderDeliverytime;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.user = user;
	}


	@Override
	public String toString() {
		return "FoodOrder [id=" + id + ", status=" + status + ", orderCreatetime=" + orderCreatetime
				+ ", orderDeliverytime=" + orderDeliverytime + ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", user=" + user + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
