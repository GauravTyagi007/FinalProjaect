package com.foodApp.FoodApp.dto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class FoodProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes="foodProduct id",required = true)
	private int id;
	@ApiModelProperty(notes="foodProduct name",required = true)
	private String name;
	@ApiModelProperty(notes="foodProduct type",required = true)
	private String type;
	@ApiModelProperty(notes="about foodProduct",required = true)
	private String about;
	@ApiModelProperty(notes="foodProduct availability",required = true)
	private String availability;
	@ApiModelProperty(notes="foodProduct price",required = true)
	private int price;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "menu_id",referencedColumnName = "id")
	private Menu menu;

	public FoodProduct(int id, String name, String type, String about, String availability, int price, Menu menu) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.about = about;
		this.availability = availability;
		this.price = price;
		this.menu = menu;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public FoodProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
