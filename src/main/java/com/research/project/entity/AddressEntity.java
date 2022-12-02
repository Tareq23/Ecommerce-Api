package com.research.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.research.project.entity.ProductEntity;
import com.research.project.projections.AddressProjection;
import com.research.project.projections.ProductProjection;
import com.research.project.security.entity.UserEntity;


@Entity(name = "addresses")
@Table(name = "addresses")


//@NamedNativeQuery get all address by user id
@NamedNativeQuery(
		name = "AddressEntity.getSpecificUserAddress",
		query = "SELECT a.id, a.email, a.phone_number as phoneNumber, a.division, a.district, "+
						"a.sub_district as subDistrict, a.is_default as isDefault, a.zip_code as zipCode "+
		"from addresses a "+
//		"inner join users u "+
//			"on a.user_id =  u.id "+
//		"where u.id = :userId",
		"where a.user_id = :userId order by a.id desc",
		resultSetMapping = "Mapping.getSpecificUserAddress"
		)
//@SqlResultSetMapping get all address by user id
@SqlResultSetMapping(name = "Mapping.getSpecificUserAddress", classes = @ConstructorResult(targetClass = AddressProjection.class, columns = {
		@ColumnResult(name = "id"), @ColumnResult(name = "email"), @ColumnResult(name = "phoneNumber"),
		@ColumnResult(name = "division"), @ColumnResult(name = "district"),  
		@ColumnResult(name = "subDistrict"), @ColumnResult(name = "isDefault"),  @ColumnResult(name = "zipCode")
}))


public class AddressEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String email;
	private String phoneNumber;
	private String division;
	private String district;
	private String subDistrict;
	
	@Column(columnDefinition = "boolean default false")
	private boolean isDefault;
	
	@Column(nullable = true)
	private String zipCode;
	
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;


	public AddressEntity(long id, String email, String phoneNumber, String division, String district,
			String subDistrict, boolean isDefault, String zipCode, UserEntity user) {
		super();
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.division = division;
		this.district = district;
		this.subDistrict = subDistrict;
		this.isDefault = isDefault;
		this.zipCode = zipCode;
		this.user = user;
	}


	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
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


	public UserEntity getUser() {
		return user;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setDivision(String division) {
		this.division = division;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}


	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}

	
	
	
	

}
