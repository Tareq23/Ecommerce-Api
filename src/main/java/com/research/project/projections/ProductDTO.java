package com.research.project.projections;

import java.math.BigInteger;

public class ProductDTO {
	
	
	
	private BigInteger id;
	private String name;
	private float price;
	private String imageUrl;
	private String description;
	private BigInteger categoryId;
	private String categoryName;
	private String categoryImageUrl;
	public ProductDTO(BigInteger id, String name, String imageUrl,  float price,String description, BigInteger categoryId,
			String categoryName, String categoryImageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.description = description;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryImageUrl = categoryImageUrl;
	}
	public BigInteger getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}
	public BigInteger getCategoryId() {
		return categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public String getCategoryImageUrl() {
		return categoryImageUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
}
