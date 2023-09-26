package com.research.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.research.project.security.entity.UserEntity;

@Entity(name = "contacts")
@Table(name = "contacts")
public class ContactEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String phoneNumber;
	
	@Lob
	private String description;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	public ContactEntity(long id, String phoneNumber, String description, UserEntity user) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.user = user;
	}

	public ContactEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
	

}
