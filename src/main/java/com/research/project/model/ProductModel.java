package com.research.project.model;

import javax.persistence.Lob;
import javax.persistence.Transient;

public class ProductModel {
	
	private long id;
	private String name;
	private float price;
	private String imageUrl;
	private String description;
	private long categoryId;
	private String categoryName;
	
	
	
	
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", price=" + price + ", imageUrl=" + imageUrl
				+ ", description=" + description + ", categoryId=" + categoryId + ", categoryName=" + categoryName
				+ "]";
	}
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductModel(long id, String name, float price, String imageUrl, String description, long categoryId,
			String categoryName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.description = description;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	
	
	public ProductModel(long id, String name, float price, String imageUrl, String description, long categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.description = description;
		this.categoryId = categoryId;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the categoryId
	 */
	public long getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	
	
	

}
