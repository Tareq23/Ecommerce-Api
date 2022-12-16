package com.research.project.projections;

import java.math.BigInteger;

import com.research.project.entity.ProductEntity;
import com.research.project.entity.ReviewEntity;

public class ReviewProjection {
	
//	private BigInteger id;
//	private String details;
//	private float regularPrice;
//	private float discountPrice;
//	private String imageUrl;
//	private Integer quantity;
//	private String description;
	
	private ReviewEntity review;
	private ProductEntity product;
	
	
	
	
	
	
	public ReviewProjection(ReviewEntity review, ProductEntity product) {
		super();
		this.review = review;
		this.product = product;
	}
	
	
//	public BigInteger getId() {
//		return id;
//	}
//	public String getDetails() {
//		return details;
//	}
//	public float getRegularPrice() {
//		return regularPrice;
//	}
//	public float getDiscountPrice() {
//		return discountPrice;
//	}
//	public String getImageUrl() {
//		return imageUrl;
//	}
//	public Integer getQuantity() {
//		return quantity;
//	}
//	public String getDescription() {
//		return description;
//	}
	public ReviewEntity getReview() {
		return review;
	}
	public ProductEntity getProduct() {
		return product;
	}
	
//	
//	public void setId(BigInteger id) {
//		this.id = id;
//	}
//	public void setDetails(String details) {
//		this.details = details;
//	}
//	public void setRegularPrice(float regularPrice) {
//		this.regularPrice = regularPrice;
//	}
//	public void setDiscountPrice(float discountPrice) {
//		this.discountPrice = discountPrice;
//	}
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
	public void setReview(ReviewEntity review) {
		this.review = review;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
	

}
