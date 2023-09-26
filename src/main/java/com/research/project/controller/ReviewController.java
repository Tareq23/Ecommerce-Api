package com.research.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.repository.ReviewRepository;
import com.research.project.security.entity.UserEntity;
import com.research.project.security.repository.UserRepository;

@RestController
@RequestMapping("/customer/review")
public class ReviewController {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public <T> Object all() {
		return ResponseEntity.ok().body(reviewRepository.reviewfindByUser(this.auth()));
	}
	
	private  UserEntity auth() {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		return userRepository.findByUsername(userDetails.getUsername());
	}

}
