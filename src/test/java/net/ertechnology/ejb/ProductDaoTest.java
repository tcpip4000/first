package net.ertechnology.ejb;

import net.ertechnology.ejb.ProductDao;
import net.ertechnology.entity.Product;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.core.Is.*;

@RunWith(Arquillian.class)
public class ProductDaoTest {

	@Inject
	private ProductDao productDao;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class)
				.addClasses(ProductDao.class, TestDataGenerator.class)
				.addPackage(Product.class.getPackage())
				.addAsManifestResource("META-INF/persistence.xml",
						"persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void should_be_deployed() {
		Assert.assertNotNull(productDao);
	}
	
	@Test
	public void testListProducts() {
		List<Product> products = productDao.listProducts();
		assertThat(products.size(), is(2));
	}
	
	@Test
	public void testListProductsSortAsc() {
		List<Product> products = productDao.listProducts();
		assertThat(products.get(0).getPrice(), is(359.99));
	}
	
	@Test
	public void testListProductsSortDesc() {
		List<Product> products = productDao.listProducts(null, false);
		assertThat(products.get(0).getPrice(), is(399.99));
	}
}
