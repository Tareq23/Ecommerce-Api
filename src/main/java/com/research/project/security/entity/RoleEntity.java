package com.research.project.security.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	
	
	
	
	public RoleEntity(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="role_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<UserEntity> listOfUsers = new ArrayList<>();
	
	
	
	
	/**
	 * @return the listOfUsers
	 */
	public List<UserEntity> getListOfUsers() {
		return listOfUsers;
	}
	/**
	 * @param listOfUsers the listOfUsers to set
	 */
	public void setListOfUsers(List<UserEntity> listOfUsers) {
		this.listOfUsers = listOfUsers;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
