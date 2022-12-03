package com.research.project.projections;

import java.math.BigInteger;
import java.util.List;

import com.research.project.entity.ProductEntity;

public class CategoryProjection {
	
	
	private long id;
	private String name;
	private String imageUrl;
	
	private List<ProductProjection> products;
	
	
	
	

	public CategoryProjection(long id, String name, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
	}

	public CategoryProjection(long id, String name, String imageUrl, List<ProductProjection> products) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public List<ProductProjection> getProducts() {
		return products;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setProducts(List<ProductProjection> products) {
		this.products = products;
	}
	
	
	

}
