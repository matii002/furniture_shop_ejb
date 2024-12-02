package com.jsf.dao;

import java.util.List;
import java.util.Map;

import com.jsf.entities.ProductEntity;
import com.jsf.entities.UserEntity;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UserDAO {
	private final static String UNIT_NAME = "furnitureShopPU";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(UserEntity user) {
		em.persist(user);
	}

	public UserEntity merge(UserEntity user) {
		return em.merge(user);
	}

	public void remove(UserEntity user) {
		em.remove(em.merge(user));
	}

	public UserEntity find(Object id) {
		return em.find(UserEntity.class, id);
	}

	public List<UserEntity> getFullList() {
		List<UserEntity> list = null;

		Query query = em.createQuery("select u from UserEntity u");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<UserEntity> getList(Map<String, Object> searchParams) {
		List<UserEntity> list = null;

		String select = "select u ";
		String from = "from UserEntity u ";
		String where = "";
		String orderby = "order by u.surname asc";

		String surname = (String) searchParams.get("surname");
		if (surname != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "u.surname like :surname ";
		}

		
		Query query = em.createQuery(select + from + where + orderby);

		if (surname != null) {
			query.setParameter("surname", surname + "%");
		}

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}