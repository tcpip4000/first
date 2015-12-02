package net.ertechnology.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.ertechnology.entity.Product;

@Stateless
public class ProductDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Product> listProducts() {
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}
}
