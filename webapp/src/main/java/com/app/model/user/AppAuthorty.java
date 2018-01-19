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
@Table(name = "APP_AUTHORTY")
public class AppAuthorty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1721546555525670335L;

	@Id
	@SequenceGenerator(name = "APP_AUTHORTIES_GEN", allocationSize = 1, sequenceName = "APP_AUTHORTIES_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_AUTHORTIES_GEN")
	@Column(name = "ID")
	private Integer id;
	private String authority;

	@OneToMany(mappedBy = "appAuthorty", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserAuhtority> userAuhtority = new HashSet<>();

	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority
	 *            the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the userAuhtority
	 */
	public Set<UserAuhtority> getUserAuhtority() {
		return userAuhtority;
	}

	/**
	 * @param userAuhtority
	 *            the userAuhtority to set
	 */
	public void setUserAuhtority(Set<UserAuhtority> userAuhtority) {
		this.userAuhtority = userAuhtority;
	}

}
