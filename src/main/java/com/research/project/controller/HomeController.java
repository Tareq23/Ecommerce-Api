package com.research.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.model.AuthenticationRequest;
import com.research.project.model.AuthorizationModel;
import com.research.project.security.entity.RoleEntity;
import com.research.project.security.entity.UserEntity;
import com.research.project.security.repository.RoleRepository;
import com.research.project.security.repository.UserRepository;
import com.research.project.security.service.CustomUserDetailsService;
import com.research.project.security.service.JwtUtils;

@RestController
public class HomeController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@GetMapping("/")
	public String index()
	{
		return "Home Index";
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<UserEntity> register(@RequestBody UserEntity user)
	{
		RoleEntity role = roleRepository.findByName("CUSTOMER");
		user.getRoles().add(role);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userRepository.delete(userRepository.findByUsername("customer1"));
		return ResponseEntity.ok().body(userRepository.save(user));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthorizationModel> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
		try {
			
			System.out.println("before request ");
			authenticationManager
				.authenticate(
						new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), 
								authenticationRequest.getPassword()));

			System.out.println("after request ");
		}catch(DisabledException e)
		{
			throw new Exception("USER_DISABLED"+e);
		}
		catch(BadCredentialsException e) {
//			throw new Exception("Bad Credential "+e);
			return ResponseEntity.ok(new AuthorizationModel("Unauthorized "));
		}
		
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		System.out.println("user Detials from login : "+userDetails.getUsername());
		
		String token = jwtUtils.generateJwtToken(userDetails);
		
		return ResponseEntity.ok().body(new AuthorizationModel(token));
	}
	
	
	

}
