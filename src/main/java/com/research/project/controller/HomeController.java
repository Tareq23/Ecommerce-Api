package com.research.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.model.AuthenticationRequest;
import com.research.project.model.AuthorizationModel;
import com.research.project.security.service.CustomUserDetailsService;
import com.research.project.security.service.JwtUtils;

@RestController
public class HomeController {
	
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
	public String register()
	{
		return "User register";
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
