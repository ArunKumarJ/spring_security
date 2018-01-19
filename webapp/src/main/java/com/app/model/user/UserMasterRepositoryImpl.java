package com.app.model.user;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.app.domain.common.BaseDaoJpa;

@Repository
public class UserMasterRepositoryImpl extends BaseDaoJpa<UserMaster, Integer> implements UserMasterRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8196564100159754307L;

	public UserMasterRepositoryImpl() {
		super(UserMaster.class);
	}

	@Override
	public UserMaster getUserMasterByUserId(String userId) {
		try {
			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<UserMaster> query = cb.createQuery(UserMaster.class);
			Root<UserMaster> root = query.from(UserMaster.class);

			ParameterExpression<String> userIdStr = cb.parameter(String.class);
			query.select(root);
			query.where(cb.equal(root.get("userId"), userIdStr));

			TypedQuery<UserMaster> typedQuery = getEntityManager().createQuery(query);
			typedQuery.setParameter(userIdStr, userId);

			return typedQuery.getSingleResult();
		} catch (NoResultException e) {
			throw new UsernameNotFoundException(String.format("%s not found.", userId));
		}
	}
}
