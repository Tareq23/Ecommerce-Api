package com.research.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.entity.CategoryEntity;
import com.research.project.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping("/admin/add")
	public ResponseEntity<CategoryEntity> addCategory(@RequestBody CategoryEntity category)
	{
		return ResponseEntity.ok().body(categoryRepository.save(category));
	}
	
	@GetMapping("/admin/all")
	public ResponseEntity<List<CategoryEntity>> showAllCategory()
	{
		return ResponseEntity.ok().body(categoryRepository.findAll());
	}

}
