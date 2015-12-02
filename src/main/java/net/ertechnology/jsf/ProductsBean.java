package net.ertechnology.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import net.ertechnology.entity.Product;

@Named
@RequestScoped
public class ProductsBean {
	private List<Product> products;

	public List<Product> getProducts() {
		if (products == null) {
			products = new ArrayList<Product>();
			products.add(new Product("xbox onew", 1230));
			products.add(new Product("taco", 59.99));
		}
		return products;
	}

}
