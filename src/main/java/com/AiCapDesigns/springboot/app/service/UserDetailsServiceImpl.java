package com.AiCapDesigns.springboot.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AiCapDesigns.springboot.app.entity.Role;
import com.AiCapDesigns.springboot.app.repository.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.AiCapDesigns.springboot.app.entity.User appUser = userRepository.findByUsuario(username).orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido"));
		
		Set grantList = new HashSet();
		for (Role role: appUser.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescripcion());
			grantList.add(grantedAuthority);
		}
		UserDetails user = (UserDetails) new User(username,appUser.getPassword(),grantList);
		
		return user;
	}

}
