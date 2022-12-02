package com.research.project.security.service;


import java.util.*;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.research.project.security.entity.RoleEntity;
import com.research.project.security.entity.UserEntity;
import com.research.project.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = userRepository.findByUsername(username);
		List<SimpleGrantedAuthority> roles= new ArrayList<>();
		if(user != null) {
//			System.out.println(" loadUserByUsername  : "+user.getFirstName());
			Set<RoleEntity> entityroles = user.getRoles();
			for (RoleEntity role : entityroles) {
				System.out.println("added role : ------------> "+role.getName());
				roles.add(new SimpleGrantedAuthority(role.getName()));
			}
//			roles.get(0).getAuthority();
			return new User(user.getUsername(),user.getPassword(),roles);
		}
//		return null;
		throw new UsernameNotFoundException("username not found : +"+username);
	}

}
