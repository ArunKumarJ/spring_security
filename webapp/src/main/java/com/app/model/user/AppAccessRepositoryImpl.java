package com.app.model.user;

import org.springframework.stereotype.Repository;

import com.app.domain.common.BaseDaoJpa;

@Repository
public class AppAccessRepositoryImpl extends BaseDaoJpa<AppAccess, Integer> implements AppAccessRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7056296637627192161L;

	public AppAccessRepositoryImpl() {
		super(AppAccess.class);
	}

}
