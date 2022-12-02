package com.research.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.entity.AddressEntity;
import com.research.project.repository.AddressRepository;
import com.research.project.security.entity.UserEntity;
import com.research.project.security.repository.UserRepository;


@RestController
@RequestMapping("/customer/address")
public class AddressController {
	
	

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@GetMapping("/all")
	public <T> Object showAllAddress()
	{
		return ResponseEntity.ok().body(addressRepository.getSpecificUserAddress(this.auth().getId()));
	}
	
	@PostMapping("/add")
	public <T> Object addNew(@RequestBody AddressEntity address)
	{
		address.setUser(this.auth());
		return ResponseEntity.ok().body(addressRepository.save(address));
	}
	
	@PutMapping("/update")
	public <T> Object update(@RequestBody AddressEntity address)
	{
		address.setUser(this.auth());
		return ResponseEntity.ok().body(addressRepository.save(address));
	}
	
	@DeleteMapping("/delete")
	public <T> Object delete(@RequestBody AddressEntity address)
	{
		addressRepository.delete(address);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	private  UserEntity auth() {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		return userRepository.findByUsername(userDetails.getUsername());
	}
	
	

}
