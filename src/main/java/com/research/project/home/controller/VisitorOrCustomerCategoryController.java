package com.research.project.home.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.entity.CategoryEntity;
import com.research.project.model.home.CategoryModel;
import com.research.project.repository.CategoryRepository;

@RestController
@RequestMapping("/visitor-or-customer")
public class VisitorOrCustomerCategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	

//	@GetMapping(path = "/only-category")
//	public ResponseEntity<Set<CategoryEntity>> showOnlyCategory()
//	{
//		return ResponseEntity.ok().body(categoryRepository.getOnlyCategory());
//	}


}
