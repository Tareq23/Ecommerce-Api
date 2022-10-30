package com.research.project.model.home;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "Categories")
public class CategoryModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String imageUrl;

	
	
	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public CategoryModel(long id) {
		super();
		this.id = id;
	}

	

	public CategoryModel(long id, String name, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
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
	
	

}
