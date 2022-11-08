package com.research.project.model;

public class AuthorizationModel {
	
	private String token;
	private String name;
	private String imageUrl;
	
	private boolean isAdmin;
	private boolean isManager;
	private boolean isCustomer;
	
	
	
	public AuthorizationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AuthorizationModel(String token, boolean isAdmin, boolean isManager, boolean isCustomer) {
		super();
		this.token = token;
		this.isAdmin = isAdmin;
		this.isManager = isManager;
		this.isCustomer = isCustomer;
	}


	public AuthorizationModel(String token) {
		super();
		this.token = token;
	}
	
	
	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}


	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	/**
	 * @return the isManager
	 */
	public boolean isManager() {
		return isManager;
	}


	/**
	 * @param isManager the isManager to set
	 */
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}


	/**
	 * @return the isCustomer
	 */
	public boolean isCustomer() {
		return isCustomer;
	}


	/**
	 * @param isCustomer the isCustomer to set
	 */
	public void setCustomer(boolean isCustomer) {
		this.isCustomer = isCustomer;
	}


	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
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
	
	

}
