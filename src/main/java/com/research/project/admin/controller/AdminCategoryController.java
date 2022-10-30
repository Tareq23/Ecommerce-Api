package com.research.project.admin.controller;

import java.io.IOException;
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
	public <T> Object addCategory(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) throws JsonMappingException, JsonProcessingException
	{
		
		if(file.isEmpty())
		{
			return "Required All Field";
		}
		
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
	
	@GetMapping("/show/{category-id}/products")
	public <T> Object showSingleCategoryProduct(@PathVariable("category-id") Long id)
	{
		return ResponseEntity.ok().body(categoryRepository.findById(id));
	}
	
	@PutMapping("/update")
	public <T> Object updateCategory(@RequestBody CategoryEntity category)
	{
//		categoryRepository.
		
		return ResponseEntity.ok().body(categoryRepository.save(category));
		
//		return "success";
	}
	
	@DeleteMapping("/delete")
	public <T> Object deleteCategory(@RequestBody CategoryEntity category) throws IOException
	{
		
		if(imageUploadHelper.deleteFile(category.getImageUrl())) {
			categoryRepository.delete(category);
			return ResponseEntity.noContent().build();
		}
		
		return "Something went to wrong";
	}

}
