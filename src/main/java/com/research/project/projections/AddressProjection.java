package com.research.project.projections;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AddressProjection {
	
	
	
	private BigInteger id;
	private String email;
	private String phoneNumber;
	private String division;
	private String district;
	private String subDistrict;
	private boolean isDefault;
	private String zipCode;
	
	
	public AddressProjection(BigInteger id, String email, String phoneNumber, String division, String district,
			String subDistrict, boolean isDefault, String zipCode) {
		super();
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.division = division;
		this.district = district;
		this.subDistrict = subDistrict;
		this.isDefault = isDefault;
		this.zipCode = zipCode;
	}
	
	
	
	
	
	public BigInteger getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getDivision() {
		return division;
	}
	public String getDistrict() {
		return district;
	}
	public String getSubDistrict() {
		return subDistrict;
	}
	public boolean isDefault() {
		return isDefault;
	}
	public String getZipCode() {
		return zipCode;
	}
	
	
	
}
