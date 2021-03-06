package com.app.security.authentication;

import java.util.Collection;

import org.springframework.security.core.Authentication;

public interface UserAuthentication extends Authentication {

	Collection<? extends GrantedAccess> getAccesses();
}
