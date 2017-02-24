package br.com.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.livraria.util.JPAUtil;

public abstract class DAO<T> {

	private EntityManager manager;

	private Class<T> clazz;

	protected DAO(Class<T> clazz) {
		manager = JPAUtil.getInstance().getEntityManager();
		this.clazz = clazz;
	}

	public T load(Object id) throws DAOException {
		try {
			return manager.find(clazz, id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void save(T obj) throws DAOException {
		try {
			manager.persist(obj);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void delete(T obj) throws DAOException {
		try {
			manager.remove(obj);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void update(T obj) throws DAOException {
		try {
			manager.merge(obj);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	protected Query createQuery(String query) throws DAOException {
		try {
			return manager.createQuery(query);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}
