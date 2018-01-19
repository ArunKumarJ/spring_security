package com.app.model.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "USER_MASTER")
public class UserMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2783150324018217782L;

	@Id
	@SequenceGenerator(name = "USER_MASTER_GEN", allocationSize = 1, sequenceName = "USER_MASTER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_MASTER_GEN")
	@Column(name = "ID")
	private Integer id;
	@Column(name = "USER_ID")
	@NaturalId
	private String userId;
	@Column(name = "Password")
	private String password;
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	@Embedded
	private Name name;
	@OneToMany(mappedBy = "userMaster", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserAccess> userAccesses = new HashSet<>();
	@OneToMany(mappedBy = "userMaster", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserAuhtority> userAuhtorities = new HashSet<>();

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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * @return the userAccesses
	 */
	public Set<UserAccess> getUserAccesses() {
		return userAccesses;
	}

	/**
	 * @param userAccesses
	 *            the userAccesses to set
	 */
	public void addUserAccess(AppAccess appAccess) {
		UserAccess userAccess = new UserAccess(this, appAccess);
		userAccesses.add(userAccess);
		appAccess.getUserAccesses().add(userAccess);
	}

	/**
	 * @return the userAuhtorities
	 */
	public Set<UserAuhtority> getUserAuhtorities() {
		return userAuhtorities;
	}

	/**
	 * @param userAuhtorities
	 *            the userAuhtorities to set
	 */
	public void addAuhtority(AppAuthorty appAuthorty) {
		UserAuhtority userAuhtority = new UserAuhtority(this, appAuthorty);
		userAuhtorities.add(userAuhtority);
		appAuthorty.setUserAuhtority(userAuhtorities);
	}

}
