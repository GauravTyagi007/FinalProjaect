package com.foodApp.FoodApp.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonManagedReference
	@OneToMany(mappedBy = "menu" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	List<FoodProduct> foodproducts;



	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setFoodproducts(List<FoodProduct> foodproducts) {
		this.foodproducts = foodproducts;
	}

	public List<FoodProduct> getFoodproducts() {
		return foodproducts;
	}


	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

}
