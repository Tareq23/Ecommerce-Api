package com.research.project.model;

public class AuthorizationModel {
	
	private String token;
	private String name;
	private String imageUrl;
	
	
	
	
	
	public AuthorizationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthorizationModel(String token) {
		super();
		this.token = token;
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
