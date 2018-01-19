package com.app.model.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "APP_ACCESS")
public class AppAccess implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8163946171430180752L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_ACCESS_ID_GEN")
	@SequenceGenerator(sequenceName = "APP_ACCESS_SEQ", name = "APP_ACCESS_ID_GEN", allocationSize = 1)
	private Integer id;
	@Column(name = "ACCESS", nullable = false)
	private String access;

	@OneToMany(mappedBy = "appAccess", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserAccess> userAccesses = new HashSet<>();

	public AppAccess() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the access
	 */
	public String getAccess() {
		return access;
	}

	/**
	 * @param access
	 *            the access to set
	 */
	public void setAccess(String access) {
		this.access = access;
	}

	/**
	 * @return the appAccesses
	 */
	public Set<UserAccess> getUserAccesses() {
		return userAccesses;
	}

	/**
	 * @param appAccesses
	 *            the appAccesses to set
	 */
	public void setUserAccesses(Set<UserAccess> userAccesses) {
		this.userAccesses = userAccesses;
	}

}
