package com.research.project.entity;

import java.util.Set;

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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.research.project.projections.ProductDTO;
import com.research.project.projections.ProductProjection;
import com.research.project.security.entity.UserEntity;


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


//@NamedNativeQuery get product by product id
@NamedNativeQuery(
		name = "ProductEntity.getProductById",
		query = "SELECT p.id, p.name, p.regular_price as regularPrice, p.discount_price as discountPrice, p.image_url as imageUrl, p.quantity, p.description, "+
		"c.id as categoryId, c.name as categoryName, b.id as brandId, b.name as brandName "+
		"from products p "+
		"inner join categories c "+
			"on p.category_id =  c.id "+
		"inner join brands b "+
			"on p.brand_id = b.id "+
		"where p.id = :id",
		resultSetMapping = "Mapping.getProductById"
		)
// @SqlResultSetMapping get product by product id
@SqlResultSetMapping(name = "Mapping.getProductById", classes = @ConstructorResult(targetClass = ProductProjection.class, columns = {
		@ColumnResult(name = "id"), @ColumnResult(name = "name"), @ColumnResult(name = "regularPrice"),
		@ColumnResult(name = "discountPrice"), @ColumnResult(name = "imageUrl"),  
		@ColumnResult(name = "quantity"), @ColumnResult(name = "description"),  @ColumnResult(name = "categoryId"),@ColumnResult(name = "categoryName"),
		@ColumnResult(name = "brandId"),@ColumnResult(name = "brandName")
}))


//@NamedNativeQuery get product search by product name
@NamedNativeQuery(
		name = "ProductEntity.getProductByName",
		query = "SELECT p.id, p.name, p.regular_price as regularPrice, p.discount_price as discountPrice, p.image_url as imageUrl, p.quantity, p.description, "+
				"c.id as categoryId, c.name as categoryName, b.id as brandId, b.name as brandName "+
				"from products p "+
				"inner join categories c "+
				"on p.category_id =  c.id "+
				"inner join brands b "+
				"on p.brand_id = b.id "+
				"where p.name like %?0",
				resultSetMapping = "Mapping.getProductByName"
		)
// @SqlResultSetMapping get product search by product name
@SqlResultSetMapping(name = "Mapping.getProductByName", classes = @ConstructorResult(targetClass = ProductProjection.class, columns = {
		@ColumnResult(name = "id"), @ColumnResult(name = "name"), @ColumnResult(name = "regularPrice"),
		@ColumnResult(name = "discountPrice"), @ColumnResult(name = "imageUrl"),  
		@ColumnResult(name = "quantity"), @ColumnResult(name = "description"),  @ColumnResult(name = "categoryId"),@ColumnResult(name = "categoryName"),
		@ColumnResult(name = "brandId"),@ColumnResult(name = "brandName")
}))

// @NamedNativeQuery for get products by category id
@NamedNativeQuery(
		name = "ProductEntity.getProductByCategoryId",
		query = "SELECT p.id, p.name, p.regular_price as regularPrice, p.discount_price as discountPrice, p.image_url as imageUrl, p.quantity, p.description, "+
		"c.id as categoryId, c.name as categoryName, b.id as brandId, b.name as brandName "+
		"from products p "+
		"inner join categories c "+
			"on p.category_id =  c.id "+
		"inner join brands b "+
			"on p.brand_id = b.id "+
		"where c.id = :id ORDER BY p.id DESC",
		resultSetMapping = "Mapping.getProductByCategoryId"
		)
// @SqlResultSetMapping get products by category id
@SqlResultSetMapping(name = "Mapping.getProductByCategoryId", classes = @ConstructorResult(targetClass = ProductProjection.class, columns = {
		@ColumnResult(name = "id"), @ColumnResult(name = "name"), @ColumnResult(name = "regularPrice"),
		@ColumnResult(name = "discountPrice"), @ColumnResult(name = "imageUrl"),  
		@ColumnResult(name = "quantity"), @ColumnResult(name = "description"),  @ColumnResult(name = "categoryId"), @ColumnResult(name = "categoryName"),
		@ColumnResult(name = "brandId"), @ColumnResult(name = "brandName")
}))




//@NamedNativeQuery getProductByCategoryIdWithLimit
@NamedNativeQuery(
		name = "ProductEntity.getProductByCategoryIdWithLimit",
		query = "SELECT p.id, p.name, p.regular_price as regularPrice, p.discount_price as discountPrice, p.image_url as imageUrl, p.quantity, p.description, "+
		"c.id as categoryId, c.name as categoryName, b.id as brandId, b.name as brandName "+
		"from products p "+
		"inner join categories c "+
			"on p.category_id =  c.id "+
		"inner join brands b "+
			"on p.brand_id = b.id "+
		"where c.id = :id ORDER BY p.id DESC limit :limitNumber",
		resultSetMapping = "Mapping.getProductByCategoryIdWithLimit"
		)
//@SqlResultSetMapping getProductByCategoryIdWithLimit
@SqlResultSetMapping(name = "Mapping.getProductByCategoryIdWithLimit", classes = @ConstructorResult(targetClass = ProductProjection.class, columns = {
		@ColumnResult(name = "id"), @ColumnResult(name = "name"), @ColumnResult(name = "regularPrice"),
		@ColumnResult(name = "discountPrice"), @ColumnResult(name = "imageUrl"),  
		@ColumnResult(name = "quantity"), @ColumnResult(name = "description"),  @ColumnResult(name = "categoryId"), @ColumnResult(name = "categoryName"),
		@ColumnResult(name = "brandId"), @ColumnResult(name = "brandName")
}))



//@NamedNativeQuery for get products by brand id
@NamedNativeQuery(
		name = "ProductEntity.getProductByBrandId",
		query = "SELECT p.id, p.name, p.regular_price as regularPrice, p.discount_price as discountPrice, p.image_url as imageUrl, p.quantity, p.description, "+
		"c.id as categoryId, c.name as categoryName, b.id as brandId, b.name as brandName "+
		"from products p "+
		"inner join categories c "+
			"on p.category_id =  c.id "+
		"inner join brands b "+
			"on p.brand_id = b.id "+
		"where b.id = :id ORDER BY p.id DESC",
		resultSetMapping = "Mapping.getProductByBrandId"
		)
//@SqlResultSetMapping get products by brand id
@SqlResultSetMapping(name = "Mapping.getProductByBrandId", classes = @ConstructorResult(targetClass = ProductProjection.class, columns = {
		@ColumnResult(name = "id"), @ColumnResult(name = "name"), @ColumnResult(name = "regularPrice"),
		@ColumnResult(name = "discountPrice"), @ColumnResult(name = "imageUrl"),  
		@ColumnResult(name = "quantity"), @ColumnResult(name = "description"),  @ColumnResult(name = "categoryId"), @ColumnResult(name = "categoryName"),
		@ColumnResult(name = "brandId"), @ColumnResult(name = "brandName")
}))


public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private float regularPrice;
	private float discountPrice;
	private String imageUrl;
	
	@Column(columnDefinition = "integer default 0")
	private Integer quantity;
	
	@Column(columnDefinition = "float default 2.5")
	private float rating;
	
	@Column(nullable = true)
	private String createdAt;
	@Column(nullable = true)
	private String updatedAt;
	
	
	@Lob
	private String description;
	
	
	@Transient
	private long categoryId;
	
	@JsonBackReference(value="category-movement")
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	
	
	
	@JsonBackReference(value="brand-movement")
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private BrandEntity brand;
	
	@JsonBackReference(value="user-product-movement")
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	
	@JsonManagedReference(value = "review-movement")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "product")
	private Set<ReviewEntity> review;
	
	
	
	public ProductEntity(long id) {
		super();
		this.id = id;
	}

	public ProductEntity(long id, String name, float regularPrice, float discountPrice, String imageUrl,
			Integer quantity, String createdAt, String updatedAt, String description, long categoryId,
			CategoryEntity category, BrandEntity brand, UserEntity user) {
		super();
		this.id = id;
		this.name = name;
		this.regularPrice = regularPrice;
		this.discountPrice = discountPrice;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.description = description;
		this.categoryId = categoryId;
		this.category = category;
		this.brand = brand;
		this.user = user;
	}

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getRegularPrice() {
		return regularPrice;
	}

	public float getDiscountPrice() {
		return discountPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public String getDescription() {
		return description;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public BrandEntity getBrand() {
		return brand;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegularPrice(float regularPrice) {
		this.regularPrice = regularPrice;
	}

	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
	
	
	
	
	
}
