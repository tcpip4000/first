package net.ertechnology.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import net.ertechnology.entity.Product;
import net.ertechnology.entity.WebOrder;

@Named
@ConversationScoped
public class Basket implements Serializable {
	
	private static final long serialVersionUID = 28928228L;
	
	private List<Product> products = new ArrayList<>();
	private double total;
	
	@Inject
	Event<WebOrder> webOrderEvent;
	
	@Inject
	Conversation conversation;
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product product) {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		products.add(product);
	}
	
	public double getTotal() {
		for (Product product : products) {
			total += product.getPrice();
		}
		
		return total;
	}

	public void checkout() {
		
		webOrderEvent.fire(new WebOrder(products));
		
		if (!conversation.isTransient()) {
			conversation.end();
		}
	}
}
