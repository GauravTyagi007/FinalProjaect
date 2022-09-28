package com.foodApp.FoodApp.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String name;
    private String email;
    private  String password;
    private String role;
    
    @JsonManagedReference
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Menu menu;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<FoodOrder> foodOrder;
    
    @Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public User(int id, String name, String email, String password, String role, Menu menu, List<FoodOrder> foodOrder) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.menu = menu;
		this.foodOrder = foodOrder;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<FoodOrder> getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(List<FoodOrder> foodOrder) {
		this.foodOrder = foodOrder;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

