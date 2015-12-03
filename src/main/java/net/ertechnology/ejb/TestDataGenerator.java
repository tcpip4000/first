package net.ertechnology.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.ertechnology.entity.Product;

@Singleton
@Startup
public class TestDataGenerator {
	
	@PersistenceContext
	EntityManager em;
	
	@PostConstruct
	public void setupTestData() {
		em.persist(new Product("Xbox ONE", 359.99));
		em.persist(new Product("Playstation 4", 399.99));
	}
	
}
