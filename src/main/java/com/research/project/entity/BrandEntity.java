package com.research.project.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "brands")
@Table(name = "brands")
public class BrandEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	
	@Column(nullable = true)
	private String createdAt;
	@Column(nullable = true)
	private String updatedAt;
	
	
	
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "brand")
	private Set<ProductEntity> products;




	public BrandEntity(long id, String name, String createdAt, String updatedAt, Set<ProductEntity> products) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.products = products;
	}




	public BrandEntity() {
		super();
		// TODO Auto-generated constructor stub
	}




	public long getId() {
		return id;
	}




	public String getName() {
		return name;
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
