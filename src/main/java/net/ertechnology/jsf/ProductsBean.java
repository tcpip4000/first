package net.ertechnology.jsf;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.ertechnology.ejb.ProductDao;
import net.ertechnology.entity.Product;

@Named
@RequestScoped
public class ProductsBean {
	private List<Product> products;
	private String filter;

	@Inject
	ProductDao productDao;
	
	private boolean order = true;

	public boolean isOrder() {
		return order;
	}

	public void setOrder(boolean order) {
		this.order = order;
	}
	
	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
		products = null;
	}

	public List<Product> getProducts() {
		if (products == null) {
			products = productDao.listProducts(filter, order);
		}
		return products;
	}

}
