package com.research.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.security.entity.UserEntity;
import com.research.project.security.repository.UserRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/info")
	public <T> Object info()
	{
		UserEntity user = this.auth();
		user.setPassword("");
		return ResponseEntity.ok().body(userRepository.findByUsername(this.auth().getUsername()));
	}
	@PutMapping("/info/update")
	public <T> Object infoUpdate(@RequestBody UserEntity user)
	{
		UserEntity tempUser = this.auth();
		tempUser.setPhoneNumber(user.getPhoneNumber());
		tempUser.setFirstName(user.getFirstName());
		tempUser.setLastName(user.getLastName());
		tempUser.setDateOfBirth(user.getDateOfBirth());
		
		return ResponseEntity.ok().body(userRepository.save(tempUser));
	}
	
	private  UserEntity auth() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		return userRepository.findByUsername(userDetails.getUsername());
	}

}
