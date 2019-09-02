package co.com.todoUno.ApiRest.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.todoUno.ApiRest.model.Product;

@Stateless
public class ProductsDAO {

	
	@PersistenceContext(unitName = "restapi_PU")
	EntityManager em;
	
	
	public List<Product> getAll() {
		return em.createQuery("SELECT g FROM Product g ORDER BY g.id", Product.class ).getResultList();
	
	}
	
	public Product findById(String id) {
		return em.find(Product.class, id);
	}
	
	public void update(Product product) {
		em.merge(product);
	}
	
	public void create(Product product) {
		em.persist(product);
	}
	
	public void delete(Product product) {
		if(!em.contains(product)) {
			product = em.merge(product);
		}
		em.remove(product);
	}
}
