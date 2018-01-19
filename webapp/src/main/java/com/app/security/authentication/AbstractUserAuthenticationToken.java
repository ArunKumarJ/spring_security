package com.app.security.authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public abstract class AbstractUserAuthenticationToken extends AbstractAuthenticationToken implements UserAuthentication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6017558515679761500L;
	private Collection<GrantedAccess> accesses;

	public AbstractUserAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Collection<? extends GrantedAccess> accesses) {
		super(authorities);
		if (accesses == null) {
			this.accesses = Collections.emptyList();
			return;
		}

		for (GrantedAccess a : accesses) {
			if (a == null) {
				throw new IllegalArgumentException("Accesses collection cannot contain any null elements");
			}
		}
		ArrayList<GrantedAccess> temp = new ArrayList<GrantedAccess>(accesses.size());
		temp.addAll(accesses);
		this.accesses = Collections.unmodifiableList(temp);
	}

	@Override
	public Collection<GrantedAccess> getAccesses() {
		return accesses;
	}

}
