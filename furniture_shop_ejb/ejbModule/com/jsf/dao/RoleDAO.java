package com.jsf.dao;

import java.util.List;
import java.util.Map;

import com.jsf.entities.ProductEntity;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RoleDAO {
	private final static String UNIT_NAME = "furnitureShopPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(ProductEntity product) {
		em.persist(product);
	}

	public ProductEntity merge(ProductEntity product) {
		return em.merge(product);
	}

	public void remove(ProductEntity product) {
		em.remove(em.merge(product));
	}

	public ProductEntity find(Object id) {
		return em.find(ProductEntity.class, id);
	}

	public List<ProductEntity> getFullList() {
		List<ProductEntity> list = null;

		Query query = em.createQuery("select p from ProductEntity p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<ProductEntity> getList(Map<String, Object> searchParams) {
		List<ProductEntity> list = null;

		// 1. Build query string with parameters
		String select = "select p ";
		String from = "from ProductEntity p ";
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