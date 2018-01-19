package com.app.domain.common;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.ObjectNotFoundException;

/**
 * 
 * @author Arun Kumar
 *
 * @param <T>
 * @param <ID>
 */
public abstract class BaseDaoJpa<T extends Serializable, ID extends Serializable> implements BaseDao<T, ID>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2195769485273874727L;

	@PersistenceContext(unitName = "domain")
	private EntityManager entityManager;
	private Class<T> clazz;

	public BaseDaoJpa(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T getById(ID id) throws ObjectNotFoundException {
		T entity = findById(id);
		if (entity == null)
			throw new ObjectNotFoundException(id, clazz.getName());
		return entity;
	}

	@Override
	public T findById(ID id) {
		T entity = entityManager.find(clazz, id);
		return entity;
	}

	@Override
	public void persist(T t) {
		Objects.requireNonNull(t);
		entityManager.persist(t);
	}

	@Override
	public void update(T t) {
		Objects.requireNonNull(t);
		entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		Objects.requireNonNull(t);
		entityManager.remove(t);
	}

	@Override
	public void refresh(T t) {
		entityManager.refresh(t);
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
