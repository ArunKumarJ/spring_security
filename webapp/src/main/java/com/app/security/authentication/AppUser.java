package com.app.security.authentication;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.Assert;

public class AppUser extends User implements AppUserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1953562469146292112L;

	private Set<GrantedAccess> accesses;

	public AppUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, Collection<? extends GrantedAccess> accesses) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.accesses = Collections.unmodifiableSet(sortAccesses(accesses));
	}

	private static SortedSet<GrantedAccess> sortAccesses(Collection<? extends GrantedAccess> accesses) {
		SortedSet<GrantedAccess> sortedAccesses = new TreeSet<GrantedAccess>((a1, a2) -> a1.getAccess().compareTo(a2.getAccess()));

		for (GrantedAccess grantedAccess : accesses) {
			Assert.notNull(grantedAccess, "GrantedAccess list cannot contain any null elements");
			sortedAccesses.add(grantedAccess);
		}
		return sortedAccesses;
	}

	@Override
	public Collection<GrantedAccess> getAccesses() {
		return accesses;
	}

}
