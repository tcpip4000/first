package net.ertechnology.rest;

import java.util.List;

import javax.inject.Inject;

import net.ertechnology.ejb.ProductDao;
import net.ertechnology.entity.Product;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@ApplicationPath("/rest")
@Path("products")
public class ProductResource extends Application {
	
	@Inject
	ProductDao productDao;
	
	@GET
	@Produces({"application/json", "application/xml"})
	public List<Product> showData() {
		return productDao.listProducts();
	}

}
