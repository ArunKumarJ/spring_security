package com.app.model.user;

import org.springframework.stereotype.Repository;

import com.app.domain.common.BaseDaoJpa;

@Repository
public class AppAuthorityRepositoryImpl extends BaseDaoJpa<AppAuthorty, Integer> implements AppAuthorityRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7324647421769969360L;

	public AppAuthorityRepositoryImpl() {
		super(AppAuthorty.class);
	}

}
