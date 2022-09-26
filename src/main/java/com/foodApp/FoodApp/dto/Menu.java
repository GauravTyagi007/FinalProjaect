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

	//@JsonManagedReference
	@OneToMany(mappedBy = "menu" ,cascade = CascadeType.ALL)
	List<FoodProduct> foodproducts;



	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private User user;
	
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
