package com.research.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.research.project.security.entity.UserEntity;

@Entity(name = "carts")
@Table(name = "carts")
public class CartEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Integer productQuantity;
	private Float productPrice;
	private long productId;
	
	@Column(nullable = true)
	private String createdAt;
	@Column(nullable = true)
	private String updatedAt;
	
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;


	public CartEntity(long id, Integer productQuantity, Float productPrice, long productId, String createdAt,
			String updatedAt, UserEntity user) {
		super();
		this.id = id;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productId = productId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}


	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public Integer getProductQuantity() {
		return productQuantity;
	}


	public Float getProductPrice() {
		return productPrice;
	}


	public long getProductId() {
		return productId;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public String getUpdatedAt() {
		return updatedAt;
	}


	public UserEntity getUser() {
		return user;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}


	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	

}
