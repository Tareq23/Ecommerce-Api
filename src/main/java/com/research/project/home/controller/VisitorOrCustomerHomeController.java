package com.research.project.home.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.controller.ProductController;
import com.research.project.entity.CategoryEntity;
import com.research.project.entity.ProductEntity;
import com.research.project.entity.ReviewEntity;
import com.research.project.model.home.CategoryModel;
import com.research.project.projections.CategoryProjection;
import com.research.project.projections.ProductProjection;
import com.research.project.repository.CategoryRepository;
import com.research.project.repository.ProductRepository;
import com.research.project.repository.ReviewRepository;

@RestController
@RequestMapping("/visitor-or-customer")
public class VisitorOrCustomerHomeController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	
	@GetMapping("/products")
	public <T> Object showProducts()
	{
		List<CategoryProjection> categories = categoryRepository.showAllCategory();
		
		for(int i=0; i<categories.size(); i++) {
			
			categories.get(i).setProducts(productRepository.getProductByCategoryIdWithLimit(categories.get(i).getId(), 5L));
//			
//			for(ProductProjection product : categories.get(i).getProducts()) {
////			 List<ReviewEntity> review =	reviewRepository.getProductReviewByProductId(product.getId().longValue());
//			 List<ReviewEntity> review =	reviewRepository.getProductReviewByProductId(new ProductEntity(product.getId().longValue()));
//			 System.out.println("------------------> review entity size : "+review.size());
//			}
		}
		
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping("/product/{id}")
	public <T> Object productDetails(@PathVariable(name = "id") Long productId)
	{
//		List<CategoryProjection> categories = categoryRepository.showAllCategory();
		
		
//		ProductProjection product = productRepository.getProductById(productId);
		return ResponseEntity.ok().body(productRepository.findById(productId));
	}
	
	@GetMapping("/product/search-by-name/{name}")
	public <T> Object productSearch(@PathVariable(name = "name") String name)
	{
		return ResponseEntity.ok().body(productRepository.findByNameContaining(name));
	}
	
	
	@GetMapping("/only-category")
	public <T> Object showCategories()
	{	
		return ResponseEntity.ok().body(categoryRepository.showAllCategory());
	}
	
	
	@PostMapping("/product/find-by-category")
	public <T> Object findProductByCategory(@RequestBody CategoryEntity category) {
		
		return ResponseEntity.ok().body(productRepository.findByCategory(category));
		
	}
	
	@PostMapping("/product/find-by-category/{startPrice}/{endPrice}")
	public <T> Object findProductByCategoryWithPriceRange(@RequestBody CategoryEntity category, @PathVariable("startPrice") float startPrice, @PathVariable("endPrice") float endPrice) {
		
		return ResponseEntity.ok().body(productRepository.getProductByRegularPriceBetweenCategory(startPrice,endPrice,category));
//		return ResponseEntity.ok().body(productRepository.findCategoryByRegularPriceBetween(category,startPrice,endPrice));
		
	}


}
