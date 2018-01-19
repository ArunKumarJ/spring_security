package com.app.service.user;

import org.springframework.security.core.userdetails.UserDetails;

import com.app.security.authentication.AppUserDetails;

public interface UserService {

	public UserDetails loadUserByUsername(String username);
}
