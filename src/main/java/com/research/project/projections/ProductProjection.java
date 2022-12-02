package com.research.project.projections;

import java.math.BigInteger;

public class ProductProjection {
	
	private BigInteger id;
	private String name;
	private float regularPrice;
	private float discountPrice;
	private String imageUrl;
	private Integer quantity;
	private String description;
	private BigInteger categoryId;
	private BigInteger brandId;
	private String categoryName;
	private String brandName;
	
	
	
	
	public ProductProjection(BigInteger id, String name, float regularPrice, float discountPrice, String imageUrl,
			Integer quantity, String description, BigInteger categoryId, String categoryName,
			BigInteger brandId, String brandName) {
		super();
		this.id = id;
		this.name = name;
		this.regularPrice = regularPrice;
		this.discountPrice = discountPrice;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.description = description;
		this.categoryId = categoryId;
		this.brandId = brandId;
		this.categoryName = categoryName;
		this.brandName = brandName;
	}


	public ProductProjection(BigInteger id, String name, float regularPrice, float discountPrice, String imageUrl,
			Integer quantity, String description, BigInteger categoryId, BigInteger brandId) {
		super();
		this.id = id;
		this.name = name;
		this.regularPrice = regularPrice;
		this.discountPrice = discountPrice;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.description = description;
		this.categoryId = categoryId;
		this.brandId = brandId;
	}
	
	
	public BigInteger getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getRegularPrice() {
		return regularPrice;
	}
	public float getDiscountPrice() {
		return discountPrice;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public String getDescription() {
		return description;
	}
	public BigInteger getCategoryId() {
		return categoryId;
	}
	public BigInteger getBrandId() {
		return brandId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public String getBrandName() {
		return brandName;
	}


	
	
}
