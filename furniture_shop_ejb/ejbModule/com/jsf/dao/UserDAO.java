package com.jsf.dao;

import java.util.List;
import java.util.Map;

import com.jsf.entities.Product;
import com.jsf.entities.User;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UserDAO {
	private final static String UNIT_NAME = "furnitureShopPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(User user) {
		em.persist(user);
	}

	public User merge(User user) {
		return em.merge(user);
	}

	public void remove(User user) {
		em.remove(em.merge(user));
	}

	public User find(Object id) {
		return em.find(User.class, id);
	}

	public List<User> getFullList() {
		List<User> list = null;

		Query query = em.createQuery("select u from User u");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<User> getList(Map<String, Object> searchParams) {
		List<User> list = null;

		// 1. Build query string with parameters
		String select = "select u ";
		String from = "from User u ";
		String where = "";
		String orderby = "order by p.price asc, p.name";

		// search for name
		String name = (String) searchParams.get("name");
		if (name != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "p.name like :name ";
		}

		// ... other parameters ...

		// 2. Create query object
		Query query = em.createQuery(select + from + where + orderby);

		// 3. Set configured parameters
		if (name != null) {
			query.setParameter("name", name + "%");
		}

		// ... other parameters ...

		// 4. Execute query and retrieve list of Product objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}