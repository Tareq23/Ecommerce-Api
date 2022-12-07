package com.research.project.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.research.project.security.entity.UserEntity;

@Entity(name="reviews")
@Table(name="reviews")
public class ReviewEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private float ratingNumber;
	
	@Lob
	private String details;
	
	
	@JsonBackReference(value="review-movement")
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductEntity product;
	
//	@JsonBackReference(value="review-image-movement")
	@OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER, mappedBy = "review")
	private Set<ReviewImageEntity> reviewImage;
	
	
//	@JsonBackReference(value="review-user-movement")
	@JsonBackReference()
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	
	

	public ReviewEntity(long id, String details, ProductEntity product, Set<ReviewImageEntity> reviewImage) {
		super();
		this.id = id;
		this.details = details;
		this.product = product;
		this.reviewImage = reviewImage;
	}
	
	
	
	
	

	public ReviewEntity(long id, float ratingNumber, String details, Set<ReviewImageEntity> reviewImage) {
		super();
		this.id = id;
		this.ratingNumber = ratingNumber;
		this.details = details;
		this.reviewImage = reviewImage;
	}






	public ReviewEntity(long id, float ratingNumber, String details, ProductEntity product,
			Set<ReviewImageEntity> reviewImage) {
		super();
		this.id = id;
		this.ratingNumber = ratingNumber;
		this.details = details;
		this.product = product;
		this.reviewImage = reviewImage;
	}



	public ReviewEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public long getId() {
		return id;
	}

	public String getDetails() {
		return details;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public Set<ReviewImageEntity> getReviewImage() {
		return reviewImage;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public void setReviewImage(Set<ReviewImageEntity> reviewImage) {
		this.reviewImage = reviewImage;
	}



	public float getRatingNumber() {
		return ratingNumber;
	}



	public void setRatingNumber(float ratingNumber) {
		this.ratingNumber = ratingNumber;
	}
	
	

}
