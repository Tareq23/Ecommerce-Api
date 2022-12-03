package com.research.project.entity;

import java.util.*;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "categories")
@Table(name = "Categories")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String imageUrl;


//	@Transient
//	private boolean isImageExists;
//	
//	@Transient
//	private boolean isImageChanged;

//	public CategoryEntity(long id, String name, String imageUrl) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.imageUrl = imageUrl;
//	}

	@JsonManagedReference(value = "category-movement")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
//	@Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
//	@JoinTable(
//			name = "product_category",
//			joinColumns = @JoinColumn(name="category_id", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(name="product_id", referencedColumnName = "id")
//			)
	private Set<ProductEntity> products;
	
	
	
	

	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}





	public CategoryEntity(long id) {
		super();
		this.id = id;
	}





	public CategoryEntity(long id, String name, String imageUrl, Set<ProductEntity> products) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.products = products;
	}





	public long getId() {
		return id;
	}





	public String getName() {
		return name;
	}





	public String getImageUrl() {
		return imageUrl;
	}





	public Set<ProductEntity> getProducts() {
		return products;
	}





	public void setId(long id) {
		this.id = id;
	}





	public void setName(String name) {
		this.name = name;
	}





	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}





	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}
	
	
	

}
