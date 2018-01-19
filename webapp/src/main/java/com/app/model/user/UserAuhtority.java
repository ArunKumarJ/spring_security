package com.app.model.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_AUHTORITY")
public class UserAuhtority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9185892498502586313L;

	@Id
	@ManyToOne
	private UserMaster userMaster;
	@Id
	@ManyToOne
	private AppAuthorty appAuthorty;

	public UserAuhtority() {
		// TODO Auto-generated constructor stub
	}

	public UserAuhtority(UserMaster userMaster, AppAuthorty appAuthorty) {
		this.userMaster = userMaster;
		this.appAuthorty = appAuthorty;
	}

	/**
	 * @return the userMaster
	 */
	public UserMaster getUserMaster() {
		return userMaster;
	}

	/**
	 * @param userMaster
	 *            the userMaster to set
	 */
	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	/**
	 * @return the appAuthorty
	 */
	public AppAuthorty getAppAuthorty() {
		return appAuthorty;
	}

	/**
	 * @param appAuthorty
	 *            the appAuthorty to set
	 */
	public void setAppAuthorty(AppAuthorty appAuthorty) {
		this.appAuthorty = appAuthorty;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appAuthorty == null) ? 0 : appAuthorty.hashCode());
		result = prime * result + ((userMaster == null) ? 0 : userMaster.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAuhtority other = (UserAuhtority) obj;
		if (appAuthorty == null) {
			if (other.appAuthorty != null)
				return false;
		} else if (!appAuthorty.equals(other.appAuthorty))
			return false;
		if (userMaster == null) {
			if (other.userMaster != null)
				return false;
		} else if (!userMaster.equals(other.userMaster))
			return false;
		return true;
	}

}
