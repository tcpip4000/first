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

	public List<Product> getProducts() {
		if (products == null) {
			products = productDao.listProducts();
			/*products = new ArrayList<Product>();
			products.add(new Product("xbox onew", 1230));
			products.add(new Product("taco", 59.99));*/
		}
		return products;
	}

}
