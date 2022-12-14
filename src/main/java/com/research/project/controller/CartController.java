package com.research.project.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.entity.AddressEntity;
import com.research.project.entity.CartEntity;
import com.research.project.entity.ProductEntity;
import com.research.project.repository.CartRepository;
import com.research.project.security.entity.UserEntity;
import com.research.project.security.repository.UserRepository;

@RestController
@RequestMapping("/customer/cart")
public class CartController {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public <T> Object all()
	{
		return ResponseEntity.ok().body(cartRepository.findAll());
	}
	
	@GetMapping("/view/{id}")
	public <T> Object findById(@PathVariable(name = "id") Long id)
	{
		return ResponseEntity.ok().body(cartRepository.findById(id));
	}
	
	@PostMapping("/add")
	public <T> Object add(@RequestBody CartEntity cart)
	{
		cart.setUser(this.auth());
		cart.setCreatedAt(LocalDate.now().toString());
		return ResponseEntity.ok().body(cartRepository.save(cart));
//		return cart;
	}
	
	@PutMapping("/update")
	public <T> Object update(@RequestBody CartEntity cart)
	{
		cart.setUser(this.auth());
		cart.setUpdatedAt(LocalDate.now().toString());
		return ResponseEntity.ok().body(cartRepository.save(cart));
//		return cart;
	}
	
	@DeleteMapping("/delete")
	public <T> Object delete(@RequestBody CartEntity cart)
	{
		cartRepository.deleteByCartId(cart.getId());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	private  UserEntity auth() {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		return userRepository.findByUsername(userDetails.getUsername());
	}

}
