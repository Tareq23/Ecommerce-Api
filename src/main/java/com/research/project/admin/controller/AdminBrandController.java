package com.research.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.entity.BrandEntity;
import com.research.project.repository.BrandRepository;
import com.research.project.repository.CategoryRepository;

@RestController
@RequestMapping("/admin/brand")
public class AdminBrandController {
	
	
	@Autowired
	private BrandRepository brandRepository;
	
	@GetMapping("/all")
	public <T> Object showAllBrand()
	{
		return ResponseEntity.ok().body(brandRepository.findAll(Sort.by(Sort.Direction.DESC, "id")));
	}
	
	@GetMapping("/details/{id}")
	public <T> Object showSingleBrand(@PathVariable(name = "id") Long id)
	{
		return ResponseEntity.ok().body(brandRepository.findById(id));
	}
	
	@PostMapping("/add")
	public <T> Object addBrand(@RequestBody BrandEntity brand)
	{
		return ResponseEntity.ok().body(brandRepository.save(brand));
	}
	
	@DeleteMapping("/delete")
	public <T> Object deleteBrand(@RequestBody BrandEntity brand)
	{
		brandRepository.delete(brand);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public <T> Object updateBrand(@RequestBody BrandEntity brand)
	{
		return ResponseEntity.ok().body(brandRepository.save(brand));
	}
	

}
