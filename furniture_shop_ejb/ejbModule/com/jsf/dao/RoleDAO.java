package com.jsf.dao;

import java.util.List;
import java.util.Map;

import com.jsf.entities.RoleEntity;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RoleDAO {
	private final static String UNIT_NAME = "furnitureShopPU";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(RoleEntity role) {
		em.persist(role);
	}

	public RoleEntity merge(RoleEntity role) {
		return em.merge(role);
	}

	public void remove(RoleEntity role) {
		em.remove(em.merge(role));
	}

	public RoleEntity find(Object id) {
		return em.find(RoleEntity.class, id);
	}

	public List<RoleEntity> getFullList() {
		List<RoleEntity> list = null;

		Query query = em.createQuery("select r from RoleEntity r");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<RoleEntity> getList(Map<String, Object> searchParams) {
		List<RoleEntity> list = null;

		String select = "select r ";
		String from = "from RoleEntity r ";
		String where = "";
		String orderby = "";

		Query query = em.createQuery(select + from + where + orderby);

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}