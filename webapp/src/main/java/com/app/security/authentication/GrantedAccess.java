package com.app.security.authentication;

public interface GrantedAccess {

	public String getAccess();

	public boolean isAllowed();
}
