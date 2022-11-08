package com.research.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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

	public CategoryEntity(long id, String name, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
	}

	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryEntity(String name) {
		super();
		this.name = name;
	}

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "category")
//	@Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
//	@JoinTable(
//			name = "product_category",
//			joinColumns = @JoinColumn(name="category_id", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(name="product_id", referencedColumnName = "id")
//			)
	private List<ProductEntity> products;

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

	/**
	 * @return the products
	 */
	public List<ProductEntity> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	/**
	 * @return the isImageExists
	 */
//	public boolean isImageExists() {
//		return isImageExists;
//	}

	/**
	 * @param isImageExists the isImageExists to set
	 */
//	public void setImageExists(boolean isImageExists) {
//		this.isImageExists = isImageExists;
//	}

	/**
	 * @return the isImageChanged
	 */
//	public boolean isImageChanged() {
//		return isImageChanged;
//	}

	/**
	 * @param isImageChanged the isImageChanged to set
	 */
//	public void setImageChanged(boolean isImageChanged) {
//		this.isImageChanged = isImageChanged;
//	}
	
	
}
