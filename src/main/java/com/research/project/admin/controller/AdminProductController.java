package com.research.project.admin.controller;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/product")
public class AdminProductController {
	
	
	public String addProduct()
	{
		return null;
	}
	
	
	public String productDetails()
	{
		return null;
	}
	
	@DeleteMapping("/delete")
	public String deleteProduct()
	{
		return null;
	}
	
	@PutMapping("/update")
	public String updateProduct()
	{
		return null;
	}
}
