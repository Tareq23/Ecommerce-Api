package com.research.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.research.project.projections.ProductDTO;


@Entity(name = "products")
@Table(name = "products")
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedNativeQuery(name = "ProductEntity.getSingleProductById", 
		query = "SELECT p.id, p.name, p.image_url as imageUrl, p.price, p.description, c.id as "+
		"categoryId, c.name as categoryName, c.image_url as categoryImageUrl FROM  products "+
		"p inner join categories c on p.category_id =  c.id where p.id = :id", resultSetMapping = "Mapping.ProductDTO")

@SqlResultSetMapping(name = "Mapping.ProductDTO", classes = @ConstructorResult(targetClass = ProductDTO.class, columns = {
		@ColumnResult(name = "id"), @ColumnResult(name = "name"), @ColumnResult(name = "imageUrl"),
		@ColumnResult(name = "price"), @ColumnResult(name = "description"),  
		@ColumnResult(name = "categoryId"),  @ColumnResult(name = "categoryName"),
		@ColumnResult(name = "categoryImageUrl")
}))
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private float price;
	private String imageUrl;
	
	@Lob
	private String description;
	
	@Transient
	private long categoryId;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
//	@JoinTable(
//			name = "product_category",
//			joinColumns = @JoinColumn(name="product_id", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(name="category_id", referencedColumnName = "id")
//			)
		
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	
	
	
	

	public ProductEntity(long id, String name, float price, String imageUrl, String description, long categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.description = description;
		this.categoryId = categoryId;
	}
	
	

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
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

	/**
	 * @return the category
	 */
	public CategoryEntity getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	
}
