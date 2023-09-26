package com.research.project.admin.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.net.http.HttpRequest;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.research.project.entity.CategoryEntity;
import com.research.project.helper.ImageUploadHelper;
import com.research.project.repository.CategoryRepository;

@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController {
	
	@Autowired
	private ImageUploadHelper imageUploadHelper;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping(path = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
	public <T> Object addCategory(@RequestParam("file") MultipartFile file, @RequestParam("body") String name) throws JsonMappingException, JsonProcessingException
	{
		
		if(file.isEmpty())
		{
			return "Required All Field";
		}
		
		System.out.println("------------------> new added category name : "+name);
	
		
		String path = imageUploadHelper.uploadFile(file).toString();

		ObjectMapper objectMapper = new ObjectMapper();
		CategoryEntity cat = objectMapper.readValue(name, CategoryEntity.class);
		if(!path.contains("error"))
		{
			cat.setImageUrl(path);
			return ResponseEntity.ok().body(categoryRepository.save(cat));
		}
		
		return "Required All Field";
	}
	
	@GetMapping("/all")
	public <T> Object showAllCategory()
	{
		return ResponseEntity.ok().body(categoryRepository.findAll());
	}
	
	
	@GetMapping("/show-only-category")
	public <T> Object showAllCategoryOnly()
	{
		return ResponseEntity.ok().body(categoryRepository.getAllCategory());
	}
	
	@GetMapping("/show/{category-id}/products")
	public <T> Object showSingleCategoryProduct(@PathVariable("category-id") Long id)
	{
		return ResponseEntity.ok().body(categoryRepository.findById(id));
//		return ResponseEntity.ok().body(categoryRepository.getProductByCategoryId(id));
	}
	
	
	
	@GetMapping("/show/{category-id}")
	public <T> Object showCategory(@PathVariable("category-id") Long id)
	{
		return ResponseEntity.ok().body(categoryRepository.findById(id));
	}
	
	
	
	@PutMapping("/update")
	public <T> Object updateCategory(@RequestBody CategoryEntity category)
	{

		return ResponseEntity.ok().body(categoryRepository.save(category));
		
	}
	
	
	@PutMapping(path="/update-with-image",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
	public <T> Object updateCategoryWithImage(@RequestParam("file") MultipartFile file,@RequestParam("isImageExists") String isImageExists, @RequestParam("isImageChanged") String isImageChanged, @RequestParam("body") String name) throws IOException
	{
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		CategoryEntity category = objectMapper.readValue(name, CategoryEntity.class);
		
		if(isImageExists.equals("true")&&isImageChanged.equals("true")) {
			imageUploadHelper.deleteFile(category.getImageUrl());
//			System.out.println("---> Admin Category controller : isImageExists"+category.isImageExists());
		}
		
		
		
		if(isImageChanged.equals("true")) {
			String path = imageUploadHelper.uploadFile(file).toString();
			if(!path.contains("error"))
			{
				category.setImageUrl(path);
				return ResponseEntity.ok().body(categoryRepository.save(category));
			}
		}
		System.out.println("---> Admin Category controller : required all field");

		return "Required All Field";
		
	}
	
	
	@DeleteMapping("/delete")
	public <T> Object deleteCategory(@RequestBody CategoryEntity category) throws IOException
	{
		
//		if(imageUploadHelper.deleteFile(category.getImageUrl())) {
//			categoryRepository.delete(category);
//			return ResponseEntity.noContent().build();
//		}
//		int rs = categoryRepository.deleteCategoryProduct(category.getId());
//		if(rs >= 0) {
//			categoryRepository.delete(category);
//		}
//		
//		System.out.println("rs ---------> delete category : "+rs);
		
		return ResponseEntity.noContent().build();
//		return "Something went to wrong";
	}

}
