package com.app.security.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthenticationToken extends AbstractUserAuthenticationToken implements UserAuthentication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8253595025700373317L;

	private Object credentials;
	private Object principal;

	public UserAuthenticationToken(Object credentials, Object principal) {
		super(null, null);
		this.credentials = credentials;
		this.principal = principal;
		setAuthenticated(false);
	}

	public UserAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Collection<? extends GrantedAccess> accesses, Object credentials,
			Object principal) {
		super(authorities, accesses);
		this.credentials = credentials;
		this.principal = principal;
		setAuthenticated(true);
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) {
		if (isAuthenticated) {
			throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		}
		super.setAuthenticated(false);
	}

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

}
