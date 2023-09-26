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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.research.project.security.entity.UserEntity;


@Entity(name="orders")
@Table(name="orders")
public class OrderEntity {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(columnDefinition = "varchar(255) default 'new-order'") // confirm, cancel, success,
	private String orderStatus;
	
	@Column(columnDefinition = "varchar(255) default 'nothing'") // completed, pending, nothing,
	private String paymentStatus;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
	private AddressEntity address;
	
	
	@Column(nullable = true)
	private String createdAt;
	@Column(nullable = true)
	private String updatedAt;
	
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "order")
	private Set<OrderDetailsEntity> details;


	

	public String getOrderStatus() {
		return orderStatus;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public OrderEntity(long id, String orderStatus, String paymentStatus, String createdAt, String updatedAt,
			UserEntity user, Set<OrderDetailsEntity> details) {
		super();
		this.id = id;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.details = details;
	}
	
	


	public OrderEntity(long id, String orderStatus, String paymentStatus, AddressEntity address, String createdAt,
			String updatedAt, UserEntity user, Set<OrderDetailsEntity> details) {
		super();
		this.id = id;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.details = details;
	}


	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
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


	public Set<OrderDetailsEntity> getDetails() {
		return details;
	}


	public void setId(long id) {
		this.id = id;
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


	public void setDetails(Set<OrderDetailsEntity> details) {
		this.details = details;
	}


	public AddressEntity getAddress() {
		return address;
	}


	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	
	
	

}
