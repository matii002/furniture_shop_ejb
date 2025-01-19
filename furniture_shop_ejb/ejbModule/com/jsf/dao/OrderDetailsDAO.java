package com.jsf.dao;

import java.util.List;
import java.util.Map;

import com.jsf.entities.OrderDetailsEntity;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class OrderDetailsDAO {
	private final static String UNIT_NAME = "furnitureShopPU";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(OrderDetailsEntity order) {
		em.persist(order);
	}

	public OrderDetailsEntity merge(OrderDetailsEntity order) {
		return em.merge(order);
	}

	public void remove(OrderDetailsEntity order) {
		em.remove(em.merge(order));
	}

	public OrderDetailsEntity find(Object id) {
		return em.find(OrderDetailsEntity.class, id);
	}

	public List<OrderDetailsEntity> getFullList() {
		List<OrderDetailsEntity> list = null;

		Query query = em.createQuery("select o from OrderDetailsEntity o");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<OrderDetailsEntity> getList(Map<String, Object> searchParams) {
		List<OrderDetailsEntity> list = null;

		String select = "select o ";
		String from = "from OrderDetailsEntity o ";
		String where = "";
		String orderby = "order by o.idOrder desc";

		Integer id = (Integer) searchParams.get("id");
		if (id != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "o.idOrder = :id ";
		}

		Query query = em.createQuery(select + from + where + orderby);

		if(id != null) {
			query.setParameter("id", id);
		}
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
