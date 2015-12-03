package net.ertechnology.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.ertechnology.ejb.ProductDao;
import net.ertechnology.entity.Product;

@Named
@RequestScoped
public class ProductDetailBean {
	
	@Inject
	ProductDao productDao;
	
	private Product product;
	private long pid;
	
	public ProductDetailBean() {
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public void loadProduct() {
		product = productDao.findProduct(pid);
	}

}
