package com.app.security.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public abstract class AbstractUserAuthenticationProvider implements AuthenticationProvider {

	private boolean forcePrincipalAsString;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// Determine username
		String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();

		UserDetails user = null;

		try {
			user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
		} catch (UsernameNotFoundException notFound) {
			throw new BadCredentialsException("Bad credentials");
		}
		try {
			additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
		} catch (AuthenticationException exception) {
			throw exception;
		}

		Object principalToReturn = user;
		if (forcePrincipalAsString) {
			principalToReturn = user.getUsername();
		}

		return createSuccessAuthentication(principalToReturn, authentication, user);
	}

	private Authentication createSuccessAuthentication(Object principalToReturn, Authentication authentication, UserDetails user) {
		/*
		 * UserAuthenticationToken token = new
		 * UserAuthenticationToken(authentication.getAuthorities(),
		 * ((UserAuthenticationToken) authentication).getAccesses(),
		 * authentication.getCredentials(), principalToReturn);
		 */
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principalToReturn, authentication.getCredentials(),
				user.getAuthorities());
		token.setDetails(authentication.getDetails());
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

	protected abstract void additionalAuthenticationChecks(UserDetails user, UsernamePasswordAuthenticationToken authentication);

	protected abstract UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication);
}
