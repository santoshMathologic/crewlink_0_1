package com.mathologic.projects.service;

import javax.transaction.Transactional;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mathologic.projects.models.User;
import com.mathologic.projects.repository.UserRepository;

@Transactional
public class SSUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	public SSUserDetailsService(UserRepository userRepository) {
		 this.userRepository=userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userRepository.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),AuthorityUtils.createAuthorityList(user.getRole().getName()));
	}

}
