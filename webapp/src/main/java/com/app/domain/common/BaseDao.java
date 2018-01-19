package com.app.domain.common;

import java.io.Serializable;

import org.hibernate.ObjectNotFoundException;

/**
 * 
 * @author Arun Kumar
 *
 * @param <T>
 * @param <ID>
 */
public interface BaseDao<T extends Serializable, ID extends Serializable> extends Serializable {

	public T getById(ID id) throws ObjectNotFoundException;

	public T findById(ID id);

	public void persist(T t);

	public void update(T t);

	public void delete(T t);

	public void refresh(T t);
}
