package com.research.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.entity.AddressEntity;
import com.research.project.repository.AddressRepository;

@RestController
@RequestMapping("/admin/address")
public class AdminAddressController {
	
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	
	@GetMapping("/all")
	public <T> Object showAllBrand()
	{
		return ResponseEntity.ok().body(addressRepository.findAll(Sort.by(Sort.Direction.DESC, "id")));
	}
	
	@PostMapping("/add")
	public <T> Object addNew(@RequestBody AddressEntity address)
	{
		return ResponseEntity.ok().body(addressRepository.save(address));
	
	}
	
	@DeleteMapping("/delete")
	public <T> Object delete(@RequestBody AddressEntity address)
	{
		addressRepository.delete(address);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
