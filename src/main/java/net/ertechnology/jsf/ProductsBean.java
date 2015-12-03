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
	
	@Inject
	ProductDao productDao;
	
	private boolean order = true;

	public boolean isOrder() {
		return order;
	}

	public void setOrder(boolean order) {
		this.order = order;
	}

	public List<Product> getProducts() {
		if (products == null) {
			products = productDao.listProducts(null, order);
		}
		return products;
	}

}
