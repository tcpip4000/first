package net.ertechnology.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ertechnology.entity.Product;

@Stateless
public class ProductDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Product> listProducts(String filter, boolean asc) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Product> query = cb.createQuery(Product.class);
		Root<Product> product = query.from(Product.class);
		
		query.select(product);
		if (asc) {
			query.orderBy(cb.asc(product.get("price")));
		} else {
			query.orderBy(cb.desc(product.get("price")));	
		}
		
		if (filter != null) {
			query.where(cb.like(product.<String>get("name"), filter + "%"));
		}
		
		return em.createQuery(query).getResultList();		
	}
	
	public List<Product> listProducts() {
		return listProducts(null, true);
		//return em.createQuery("select p from Product p", Product.class).getResultList();
	}

	public Product findProduct(long pid) {
		return em.find(Product.class, pid);
	}
}
