package com.app.service.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.user.UserMaster;
import com.app.model.user.UserMasterRepository;
import com.app.security.authentication.AppUser;
import com.app.security.authentication.AppUserDetails;
import com.app.security.authentication.SimpleGrantedAccess;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMasterRepository userMasterRepository;

	@Override
	@Transactional(propagation=Propagation.NEVER)
	public UserDetails loadUserByUsername(String username) {
		UserMaster userMaster = userMasterRepository.getUserMasterByUserId(username);
		if (userMaster == null)
			throw new UsernameNotFoundException(String.format("%s not found.", username));

		Collection<SimpleGrantedAccess> accesses = new HashSet<>();
		Collection<SimpleGrantedAuthority> authorities = new HashSet<>();
		userMaster.getUserAccesses().forEach(s -> {
			accesses.add(new SimpleGrantedAccess(s.getAppAccess().getAccess(), true));
		});

		userMaster.getUserAuhtorities().forEach(s -> {
			authorities.add(new SimpleGrantedAuthority(s.getAppAuthorty().getAuthority()));
		});

		// AppUserDetails details = new AppUser(username, userMaster.getPassword(),
		// true, true, true, true, authorities, accesses);

		UserDetails details = new User(username, userMaster.getPassword(), true, true, true, true, authorities);
		return details;
	}

}
