package com.research.project.security.entity;



import java.util.HashSet;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.research.project.entity.AddressEntity;
import com.research.project.entity.CartEntity;
import com.research.project.entity.ContactEntity;
import com.research.project.entity.OrderEntity;
import com.research.project.entity.ProductEntity;
import com.research.project.entity.ReviewEntity;

@Entity(name = "users")
@Table(name = "users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String phoneNumber;
	
	@Column(nullable = true)
	private String dateOfBirth;
	
	
	@Column(nullable = true)
	private String createdAt;
	@Column(nullable = true)
	private String updatedAt;
	
	
	@ManyToMany
	@JoinTable(name="user_roles",
		joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
	
	private Set<RoleEntity> roles = new HashSet<>();
	
	
	
	
	

	@JsonManagedReference(value = "user-product-movement")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
	private Set<ProductEntity> products;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
	private Set<AddressEntity> addresses;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
	private Set<CartEntity> carts;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
	private Set<ContactEntity> contacts;
	
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
	private Set<OrderEntity> orders;
	
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
	private Set<ReviewEntity> review;


	
	
	
	
	public UserEntity(long id, String firstName, String lastName, String username, String password, String phoneNumber,
			String dateOfBirth, String createdAt, String updatedAt, Set<RoleEntity> roles, Set<ProductEntity> products,
			Set<AddressEntity> addresses, Set<CartEntity> carts, Set<ContactEntity> contacts, Set<OrderEntity> orders,
			Set<ReviewEntity> review) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.roles = roles;
		this.products = products;
		this.addresses = addresses;
		this.carts = carts;
		this.contacts = contacts;
		this.orders = orders;
		this.review = review;
	}


	public UserEntity(long id, String firstName, String lastName, String username, String password, String phoneNumber,
			String createdAt, String updatedAt, Set<RoleEntity> roles, Set<ProductEntity> products,
			Set<AddressEntity> addresses, Set<CartEntity> carts, Set<ContactEntity> contacts, Set<OrderEntity> orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.roles = roles;
		this.products = products;
		this.addresses = addresses;
		this.carts = carts;
		this.contacts = contacts;
		this.orders = orders;
	}


	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public String getUpdatedAt() {
		return updatedAt;
	}


	public Set<RoleEntity> getRoles() {
		return roles;
	}


	public Set<ProductEntity> getProducts() {
		return products;
	}


	public Set<AddressEntity> getAddresses() {
		return addresses;
	}


	public Set<CartEntity> getCarts() {
		return carts;
	}


	public Set<ContactEntity> getContacts() {
		return contacts;
	}


	public Set<OrderEntity> getOrders() {
		return orders;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}


	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}


	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}


	public void setAddresses(Set<AddressEntity> addresses) {
		this.addresses = addresses;
	}


	public void setCarts(Set<CartEntity> carts) {
		this.carts = carts;
	}


	public void setContacts(Set<ContactEntity> contacts) {
		this.contacts = contacts;
	}


	public void setOrders(Set<OrderEntity> orders) {
		this.orders = orders;
	}


	public Set<ReviewEntity> getReview() {
		return review;
	}


	public void setReview(Set<ReviewEntity> review) {
		this.review = review;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	

}
