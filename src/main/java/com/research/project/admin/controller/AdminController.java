package com.research.project.admin.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.security.entity.CheckEntity;
import com.research.project.security.entity.UserEntity;
import com.research.project.security.repository.CheckRepository;
import com.research.project.security.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CheckRepository checkRepository;
	
	@GetMapping()
	public String adminHome()
	{
		return "Admin Home";
	}
	
	@GetMapping("/all/users")
	public List<UserEntity> getAllUsers( )
	{
		System.out.println("all users checked.......................");
		return userRepository.findAll();
	}
	
	@GetMapping("/user")
	public ResponseEntity<UserEntity> user()
	{
		return ResponseEntity.ok().body(userRepository.findById(1L).get());
	}
	
	@GetMapping("/check")
	public ResponseEntity<List<CheckEntity>> getAllUser()
	{
		return ResponseEntity.ok().body(checkRepository.findAll());
	}
	

}
