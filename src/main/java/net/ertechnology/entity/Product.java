package net.ertechnology.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id 
	@GeneratedValue
	private long id;
	

	private String name;
	private double price;

	
	public Product() {
	}
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
