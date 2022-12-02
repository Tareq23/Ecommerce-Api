package com.research.project.admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.header.Header;
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
import com.research.project.entity.ProductEntity;
import com.research.project.helper.ImageUploadHelper;
import com.research.project.model.ErrorResponse;
import com.research.project.repository.ProductRepository;

@RestController
@RequestMapping("/admin/product")
public class AdminProductController {
	
	@Autowired
	private ImageUploadHelper imageUploadHelper;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/add")
	public <T> Object addProduct(@RequestParam("file") MultipartFile file, @RequestParam("body") String body) throws JsonMappingException, JsonProcessingException
	{
		System.out.println("admin product controller : "+body);
		ObjectMapper objectMapper = new ObjectMapper();
		
		ProductEntity product = objectMapper.readValue(body, ProductEntity.class);
		String imageUrl;
		try {
			imageUrl = new ImageUploadHelper().uploadFile(file).toString();
			if(!imageUrl.contains("error"))
			{
				product.setImageUrl(imageUrl);
				return ResponseEntity.ok().body(productRepository.save(product));
			}
		} catch (IOException e) {
			
		}
		return new ResponseEntity<>(new ErrorResponse("Something Went to be wrong", "Try Again"),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/view/all")
	public <T> Object showAllProduct()
	{
//		return ResponseEntity.ok().body(productRepository.findAll());
//		return "View all Product";
		return ResponseEntity.ok().body(productRepository.findAll(Sort.by(Sort.Direction.DESC, "id")));
	}
	
	
	
	
	@GetMapping("/view/all/category/{id}")
	public <T> Object showAllProductByCategory(@PathVariable("id") Long id)
	{
//		int page = 0;
//		int size = 3;
//		System.out.println("showAllProductByCategory ------------------------> "+id);
//		Pageable  pageable = PageRequest.of(page, size, Sort.by("level").descending());
//	
//		return ResponseEntity.ok().body(productRepository.getProductByCategoryId(id,pageable));
		return ResponseEntity.ok().body(productRepository.getProductByCategoryId(id));
	}
	
	@GetMapping("/view/by-product-name")
	public <T> Object showAllProductSearchByName(@RequestParam(name="name") String productName)
	{
//		int page = 0;
//		int size = 3;
//		System.out.println("showAllProductByCategory ------------------------> "+id);
//		Pageable  pageable = PageRequest.of(page, size, Sort.by("level").descending());
//	
//		return ResponseEntity.ok().body(productRepository.getProductByCategoryId(id,pageable));
		System.out.println("product name ---------------> : "+productName);
		return ResponseEntity.ok().body(productRepository.getProductByName(productName));
	}
	
	
	@GetMapping("/view/all/brand/{id}")
	public <T> Object showAllProductByBrand(@PathVariable("id") Long id)
	{
//		int page = 0;
//		int size = 3;
//		System.out.println("showAllProductByCategory ------------------------> "+id);
//		Pageable  pageable = PageRequest.of(page, size, Sort.by("level").descending());
//	
//		return ResponseEntity.ok().body(productRepository.getProductByCategoryId(id,pageable));
		return ResponseEntity.ok().body(productRepository.getProductByBrandId(id));
	}
	
	
	
	@GetMapping("/view/details/{id}")
	public <T> Object productDetails(@PathVariable("id") Long id)
	{
//		return "Product Details";
		System.out.println("Product Id ----------------> "+id);
//		return ResponseEntity.ok().body(productRepository.findById(id).get());
//		return ResponseEntity.ok().body(productRepository.getSingleProductById(id));
		return ResponseEntity.ok().body(productRepository.getProductById(id));
		
	}
	
	@DeleteMapping("/delete")
	public <T> Object deleteProduct(@RequestBody ProductEntity product) throws IOException
	{
		if(product.getImageUrl() == null) {
			product.setImageUrl("http://localhost:8080/images/1668336904674.jpg");
		}
		if(new ImageUploadHelper().deleteFile(product.getImageUrl()))
		{
			productRepository.delete(product);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		else {
			productRepository.delete(product);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
//		productRepository.delete(product);
//		return new ResponseEntity<>(HttpStatus.ACCEPTED);
//		return new ResponseEntity<Error>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/update")
	public <T> Object updateProduct(@RequestBody ProductEntity product)
	{
		return ResponseEntity.ok().body(productRepository.save(product));
	}
	
	@PutMapping(path="/update-with-image",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
	public <T> Object updateCategoryWithImage(@RequestParam("file") MultipartFile file,@RequestParam("isImageExists") String isImageExists, @RequestParam("isImageChanged") String isImageChanged, @RequestParam("body") String name) throws IOException
	{
		
//		System.out.println("Product Controller --------------------------> with image");
		
		
		
		ObjectMapper objectMapper = new ObjectMapper();

		ProductEntity product =  objectMapper.readValue(name, ProductEntity.class);
//		System.out.println("Product Controller --------------------------> "+product.getId());
//		System.out.println("Product Controller --------------------------> "+ product.getName());
//		System.out.println("Product Controller --------------------------> "+product.getDescription());
//		System.out.println("Product Controller --------------------------> with image"+product.getImageUrl());
//		System.out.println("Product Controller --------------------------> with image"+product.getCategory().getId());
		
		if(isImageExists.equals("true")&&isImageChanged.equals("true")) {
			imageUploadHelper.deleteFile(product.getImageUrl());
		}
		
		if(isImageChanged.equals("true")) {
			String path = imageUploadHelper.uploadFile(file).toString();
			if(!path.contains("error"))
			{
				product.setImageUrl(path);
//				return ResponseEntity.accepted().body(productRepository.updateProduct(product.getId(), product.getName(), product.getDescription(),product.getImageUrl(),product.getCategory().getId()));
			}
		}
		return ResponseEntity.accepted().body(productRepository.updateProduct(product.getId(), product.getName(),product.getRegularPrice(), product.getDescription(),product.getImageUrl(),product.getCategory().getId()));
		
	}
	
	
	@PutMapping("/update/image")
	public <T> Object updateImage(@RequestParam("image") MultipartFile file, @RequestParam("id") Long id) throws IOException
	{
		ProductEntity product = productRepository.findById(id).get();
		if(new ImageUploadHelper().deleteFile(product.getImageUrl()))
		{
			String imageUrl = new ImageUploadHelper().uploadFile(file).toString();
			if(!imageUrl.contains("error"))
			{
				product.setImageUrl(imageUrl);
				return ResponseEntity.ok().body(productRepository.save(product));
			}
		}
		
		return new ResponseEntity<Error>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/view/{id}/details-with-category")
	public <T> Object getProductWithCategory(@PathVariable("id") Long id) {
		
//		System.out.println(productRepository.findByProductId(id));
		

		return new ResponseEntity<Error>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
