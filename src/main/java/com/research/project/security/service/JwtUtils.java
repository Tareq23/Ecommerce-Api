package com.research.project.security.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

import io.jsonwebtoken.security.SignatureException;

@Service
public class JwtUtils {
	
	
//	private final String SECRET_KEY = "SECRET12*x34*y56*zKEY";
	private final String SECRET_KEY = "SECRET22k3j3k3j3k3j3k3j3k3j3k3j3k3j3k3j3k12KEYSECRET12KEYSECRET12KEYSECRET12KEYSECRET12KEYSECRET12KEY123456tareq23";
	private long jwtExpirationInMs = 60*60*1000;
	
	
	public String generateJwtToken(UserDetails userDetails)
	{
		Map<String, Object> claims = new HashMap<>();
		Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
		
		System.out.println("jwtUtil class : generateJwtToken method : roles size -> "+roles.size());
		
		if (roles.contains(new SimpleGrantedAuthority("ADMIN"))) {
			claims.put("isAdmin", true);
		}
		if (roles.contains(new SimpleGrantedAuthority("CUSTOMER"))) {
			claims.put("isCustomer", true);
		}
		
		if(roles.contains(new SimpleGrantedAuthority("MANAGER")))
		{
			claims.put("isManager", true);
		}
		
//		System.out.println("check is admin claims : -> "+claims.get("isAdmin"));
		
		return doGenerateToken(claims, userDetails.getUsername());
	}
	
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
				.signWith(
						SignatureAlgorithm.HS512, 
						SECRET_KEY)
				.compact();
	}
	
	public boolean validateToken(String authToken) {
		try {
			// Jwt token has not been tampered with
			Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
			throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
		} catch (ExpiredJwtException ex) {
			throw new ExpiredJwtException( null, null, "Token has Expired", ex);
		}
	}
	
	public String getUsernameFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

		return claims.getSubject();
	}

	public List<SimpleGrantedAuthority> getRolesFromToken(String authToken) {
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken).getBody();
		Boolean isAdmin = claims.get("isAdmin", Boolean.class);
		Boolean isManager = claims.get("isManager", Boolean.class);
		Boolean isCustomer = claims.get("isCustomer", Boolean.class);
		System.out.println("jwt util class : claim size = "+claims.size());
		
//		for(int i=0; i<claims.size(); i++)
//		{
//			clai
//		}
		
		
		System.out.println("isAdmin   --> : "+isAdmin);
		System.out.println("isManager   --> : "+isManager);
		System.out.println("isCustomer   --> : "+isCustomer);
		
		if (isAdmin != null && isAdmin == true) {
//			roles = Arrays.asList(new SimpleGrantedAuthority("admin"));
			roles.add(new SimpleGrantedAuthority("ADMIN"));
		}
		if (isManager != null && isManager == true) {
			roles.add(new SimpleGrantedAuthority("MANAGER"));
		}
		if(isCustomer != null && isCustomer == true) {
			roles.add(new SimpleGrantedAuthority("CUSTOMER"));
		}
		System.out.println("jwt util class : roles size = "+roles.size());
		return roles;
	}

}
