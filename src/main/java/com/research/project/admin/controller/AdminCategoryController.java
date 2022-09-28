package com.research.project.admin.controller;

import java.net.http.HttpRequest;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		
		
//		return ResponseEntity.ok().body(categoryEntity);
		
		String path = imageUploadHelper.uploadFile(file);
//		String path = "weelo";
		ObjectMapper objectMapper = new ObjectMapper();
		CategoryEntity cat = objectMapper.readValue(name, CategoryEntity.class);
		if(!path.contains("error"))
		{
			
//			CategoryEntity category = new CategoryEntity(name);
//			category.setImageUrl(path);
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
	
	@PutMapping("/update")
	public String updateCategory()
	{
		return null;
	}
	
	@DeleteMapping("/delete")
	public String deleteCategory()
	{
		return null;
	}

}
