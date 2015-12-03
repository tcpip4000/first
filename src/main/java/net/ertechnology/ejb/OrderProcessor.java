package net.ertechnology.ejb;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.ertechnology.entity.WebOrder;

@Stateless
public class OrderProcessor {

	@PersistenceContext
	EntityManager em;
	
	public void saveOrder(@Observes WebOrder webOrder) {
		em.persist(webOrder);
	}
}
