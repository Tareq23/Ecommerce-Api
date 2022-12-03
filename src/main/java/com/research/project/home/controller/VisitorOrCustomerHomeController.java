package com.research.project.home.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.controller.ProductController;
import com.research.project.entity.CategoryEntity;
import com.research.project.entity.ProductEntity;
import com.research.project.model.home.CategoryModel;
import com.research.project.projections.CategoryProjection;
import com.research.project.projections.ProductProjection;
import com.research.project.repository.CategoryRepository;
import com.research.project.repository.ProductRepository;

@RestController
@RequestMapping("/visitor-or-customer")
public class VisitorOrCustomerHomeController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping("/products")
	public <T> Object showProducts()
	{
		List<CategoryProjection> categories = categoryRepository.showAllCategory();
		
		for(int i=0; i<categories.size(); i++) {
			
			categories.get(i).setProducts(productRepository.getProductByCategoryIdWithLimit(categories.get(i).getId(), 5L));
		}
		
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping("/only-category")
	public <T> Object showCategories()
	{	
		return ResponseEntity.ok().body(categoryRepository.showAllCategory());
	}


}
