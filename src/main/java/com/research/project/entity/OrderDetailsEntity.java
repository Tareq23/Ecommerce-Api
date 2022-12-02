package com.research.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "order_details")
@Table(name = "order_details")
public class OrderDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Integer productQuantity;
	private Float productPrice;
	private long productId;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private OrderEntity order;

	public OrderDetailsEntity(long id, Integer productQuantity, Float productPrice, long productId, OrderEntity order) {
		super();
		this.id = id;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productId = productId;
		this.order = order;
	}

	public OrderDetailsEntity() {
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

	public OrderEntity getOrder() {
		return order;
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

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	
	
	
	
}
