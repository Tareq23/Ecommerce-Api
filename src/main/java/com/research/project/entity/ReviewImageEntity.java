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

@Entity(name="review_images")
@Table(name="review_images")
public class ReviewImageEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String url;
	
	
	@JsonBackReference(value="review-image-movement")
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "review_id")
	private ReviewEntity review;


	public ReviewImageEntity(long id, String url, ReviewEntity review) {
		super();
		this.id = id;
		this.url = url;
		this.review = review;
	}


	public ReviewImageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public String getUrl() {
		return url;
	}


	public ReviewEntity getReview() {
		return review;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public void setReview(ReviewEntity review) {
		this.review = review;
	}
	
	
	

}
