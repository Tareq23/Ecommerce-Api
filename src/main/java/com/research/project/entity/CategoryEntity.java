package com.research.project.entity;

import java.util.List;
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

	@Column(nullable = true)
	private String createdAt;
	@Column(nullable = true)
	private String updatedAt;

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

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
//	@Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
//	@JoinTable(
//			name = "product_category",
//			joinColumns = @JoinColumn(name="category_id", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(name="product_id", referencedColumnName = "id")
//			)
	private Set<ProductEntity> products;

public CategoryEntity(long id, String name, String imageUrl, String createdAt, String updatedAt,
		Set<ProductEntity> products) {
	super();
	this.id = id;
	this.name = name;
	this.imageUrl = imageUrl;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.products = products;
}

public CategoryEntity() {
	super();
	// TODO Auto-generated constructor stub
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

public String getCreatedAt() {
	return createdAt;
}

public String getUpdatedAt() {
	return updatedAt;
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

public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}

public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
}

public void setProducts(Set<ProductEntity> products) {
	this.products = products;
}

	

}
