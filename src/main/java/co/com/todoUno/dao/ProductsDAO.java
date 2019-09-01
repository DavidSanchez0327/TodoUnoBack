package co.com.todoUno.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.com.todoUno.model.Products;



@Stateless
public class ProductsDAO {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest:
    public void persist(Products guest) {
        em.persist(guest);
    }

    // Retrieves all the guests:
    public List<Products> getAllGuests() {
        TypedQuery<Products> query = em.createQuery(
            "SELECT g FROM Guest g ORDER BY g.id", Products.class);
        return query.getResultList();
    }

}
