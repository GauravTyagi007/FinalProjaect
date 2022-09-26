package com.foodApp.FoodApp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Menu {

	@Id
	private int id;

	@JsonManagedReference
	@OneToMany(mappedBy = "menu")
	List<FoodProduct> foodproducts;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn
	private User user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Menu(int id) {
		super();
		this.id = id;
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

}
