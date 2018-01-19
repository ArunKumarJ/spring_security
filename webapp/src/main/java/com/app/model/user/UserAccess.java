package com.app.model.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ACCESS")
public class UserAccess implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 81617774538048387L;

	@Id
	@ManyToOne
	private UserMaster userMaster;
	@Id
	@ManyToOne
	private AppAccess appAccess;

	public UserAccess() {
		// TODO Auto-generated constructor stub
	}

	public UserAccess(UserMaster userMaster, AppAccess appAccess) {
		this.userMaster = userMaster;
		this.appAccess = appAccess;
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
	 * @return the appAccess
	 */
	public AppAccess getAppAccess() {
		return appAccess;
	}

	/**
	 * @param appAccess
	 *            the appAccess to set
	 */
	public void setAppAccess(AppAccess appAccess) {
		this.appAccess = appAccess;
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
		result = prime * result + ((appAccess == null) ? 0 : appAccess.hashCode());
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
		UserAccess other = (UserAccess) obj;
		if (appAccess == null) {
			if (other.appAccess != null)
				return false;
		} else if (!appAccess.equals(other.appAccess))
			return false;
		if (userMaster == null) {
			if (other.userMaster != null)
				return false;
		} else if (!userMaster.equals(other.userMaster))
			return false;
		return true;
	}

}
