package net.ertechnology.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class WebOrder {

	@Id @GeneratedValue
	private long id;
	
	@ManyToMany
	private List<Product> products;

	public WebOrder() {
	}
	
	public WebOrder(List<Product> products) {
		this.products = products;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public long getId() {
		return id;
	}
	
}
