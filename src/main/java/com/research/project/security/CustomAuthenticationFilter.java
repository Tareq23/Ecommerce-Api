package com.research.project.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.research.project.security.service.JwtUtils;



@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter{

	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
//		System.out.println("Filter class --> jwt token : ");
//		
//		System.out.println("Request Path : "+request.getRequestURI());
	
		
		String jwtToken = extractJwtToken(request);
//		System.out.println("Filter class --> jwt token : "+jwtToken);
////		System.out.println(jwtUtils.getUsernameFromToken(jwtToken));
//		if(jwtUtils.validateToken(jwtToken)&&StringUtils.hasText(jwtToken)) {
//			System.out.println("Valid Token");
//		}
////		List<SimpleGrantedAuthority> roles = jwtUtils.getRolesFromToken(jwtToken);
////		stem.out.println(roles.get(0));
		if (StringUtils.hasText(jwtToken) && jwtUtils.validateToken(jwtToken)) {
			
			System.out.println("customeAuthenticationFilter class : valid token");
			
			
			UserDetails userDetails = new User(jwtUtils.getUsernameFromToken(jwtToken), "",
					jwtUtils.getRolesFromToken(jwtToken));

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());
			// After setting the Authentication in the context, we specify
			// that the current user is authenticated. So it passes the
			// Spring Security Configurations successfully.
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			
			System.out.println(userDetails.getUsername());
			
		} else {
			System.out.println("Cannot set the Security Context");
		}
		
		
		
		
		filterChain.doFilter(request, response);
		
	}
	
	
	
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		// TODO Auto-generated method stub
//		return super.shouldNotFilter(request);
		return (
				new AntPathMatcher().match("/product/**", request.getServletPath()) ||
				new AntPathMatcher().match("/login", request.getServletPath()) ||
				new AntPathMatcher().match("/register", request.getServletPath()) ||				
				new AntPathMatcher().match("/", request.getServletPath()) ||				
				new AntPathMatcher().match("/categories/**", request.getServletPath())		
//				new AntPathMatcher().match("/admin/**", request.getServletPath())			
				);
	}




	private String extractJwtToken(HttpServletRequest request) {
		
		String bearerToken = request.getHeader("Authorization");
//		System.out.println(bearerToken);
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
		
	}

}
