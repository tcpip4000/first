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
	
	public List<Product> listProducts() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Product> query = cb.createQuery(Product.class);
		Root<Product> product = query.from(Product.class);
		
		query.select(product);
		return em.createQuery(query).getResultList();
		
		//return em.createQuery("select p from Product p", Product.class).getResultList();
	}
}
