package com.research.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.entity.CategoryEntity;
import com.research.project.repository.CategoryRepository;

@RestController
@RequestMapping("/home/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	
	
	@GetMapping("/show/{category-id}/products")
	public ResponseEntity<CategoryEntity> showCategory(@PathVariable("category-id") Long id)
	{
		return ResponseEntity.ok().body(categoryRepository.findById(id).get());
	}
	
	@GetMapping("/show/all")
	public ResponseEntity<List<CategoryEntity>> showAllCategory()
	{
		return ResponseEntity.ok().body(categoryRepository.findAll());
	}

}
