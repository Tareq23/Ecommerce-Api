package com.research.project.projections;

import com.research.project.entity.OrderEntity;
import com.research.project.security.entity.UserEntity;

public class OrderDetailsProjection {
	
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private OrderEntity order;
	
	public OrderDetailsProjection(String firstName, String lastName, String phoneNumber, OrderEntity order) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.order = order;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	
	
	
	

}
