package com.jsf.dao;

import java.util.List;
import java.util.Map;

import com.jsf.entities.OrderProductEntity;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class OrderProductDAO {
	
	private final static String UNIT_NAME = "furnitureShopPU";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(OrderProductEntity orderProduct) {
		em.persist(orderProduct);
	}

	public OrderProductEntity merge(OrderProductEntity order) {
		return em.merge(order);
	}

	public void remove(OrderProductEntity order) {
		em.remove(em.merge(order));
	}

	public OrderProductEntity find(Object id) {
		return em.find(OrderProductEntity.class, id);
	}

	public List<OrderProductEntity> getFullList() {
		List<OrderProductEntity> list = null;

		Query query = em.createQuery("select o from OrderProductEntity o");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<OrderProductEntity> getList(Map<String, Object> searchParams) {
		List<OrderProductEntity> list = null;
		
		String select = "select o ";
	    String from = "from OrderProductEntity o ";
	    String groupby = " ";
	    String orderby = "order by o.orderDetail.idOrder desc";

	    Query query = em.createQuery(select + from + groupby + orderby);

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
