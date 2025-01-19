package com.jsf.dao;

import java.util.List;
import java.util.Map;

import com.jsf.entities.PermissionEntity;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PermissionDAO {
	private final static String UNIT_NAME = "furnitureShopPU";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(PermissionEntity permission) {
		em.persist(permission);
	}

	public PermissionEntity merge(PermissionEntity permission) {
		return em.merge(permission);
	}

	public void remove(PermissionEntity permission) {
		em.remove(em.merge(permission));
	}

	public PermissionEntity find(Object id) {
		return em.find(PermissionEntity.class, id);
	}

	public List<PermissionEntity> getFullList() {
		List<PermissionEntity> list = null;

		Query query = em.createQuery("select p from PermissionEntity p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<PermissionEntity> getList(Map<String, Object> searchParams) {
		List<PermissionEntity> list = null;

		String select = "select p ";
		String from = "from PermissionEntity p ";
		String where = "";
		String orderby = "";

		String name = (String) searchParams.get("name");
		if (name != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "p.name like :name ";
		}

		Query query = em.createQuery(select + from + orderby);

		if (name != null) {
			query.setParameter("name", name + "%");
		}

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}