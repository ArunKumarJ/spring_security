package com.app.security.authentication;

import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;

public interface AppUserDetails extends UserDetails {

	Collection<? extends GrantedAccess> getAccesses();
}
