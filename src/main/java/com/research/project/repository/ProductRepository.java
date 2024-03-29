package com.research.project.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;

import com.research.project.entity.BrandEntity;
import com.research.project.entity.CategoryEntity;
import com.research.project.entity.ProductEntity;
import com.research.project.model.ProductModel;
import com.research.project.projections.ProductDTO;
import com.research.project.projections.ProductProjection;

@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
	
	@Transactional
	@Modifying
	@Query(value="update products p set p.name = :name, p.price = :price, p.description = :description, p.image_url = :imageUrl, p.category_id = :categoryId where p.id = :id",nativeQuery = true)
	int updateProduct(@Param("id") Long id, @Param("name") String name, 
			@Param("price") float price,
			@Param("description") String description,
			@Param("imageUrl") String imageUrl,
			@Param("categoryId") Long categoryId );
	
	
//	@Query(nativeQuery = true, value="SELECT new com.research.project.projections.ProductProjection(p.id,  p.name, p.regularPrice, p.discountPrice, p.imageUrl,"
//			+ " p.quantity, p.description, p.categoryId, p.brandId) from products p where p.id=?1 limit 1")
	@Query(nativeQuery = true)
	ProductProjection getProductById(Long id);

	
	@Query(nativeQuery = true)
	List<ProductProjection> getProductByCategoryId(Long id);
	
	
	@Query(nativeQuery = true)
	List<ProductProjection> getProductByCategoryIdWithLimit(Long id, Long limitNumber);
	
	@Query(nativeQuery = true)
	List<ProductProjection> getProductByBrandId(Long id);
	
	
	@Query(nativeQuery = true)
	List<ProductProjection> getProductByName(String productName);
	
	
	@Query(value="select p from products p where p.category_id = :categoryId", nativeQuery = true)
	List<ProductProjection> getProductsForHomePage(Long categoryId);
	
	
	List<ProductEntity> findByNameContaining(String name);
	
	List<ProductEntity> findByBrand(BrandEntity brand);
	
	
	
	List<ProductEntity> findByCategory(CategoryEntity category);
	
	
	List<ProductEntity> findByRegularPriceBetween(float startPrice, float endPrice);

	

	@Query("select p from products p where p.category = ?3 and p.regularPrice between ?1 and ?2")
	List<ProductEntity> getProductByRegularPriceBetweenCategory( float startPrice, float endPrice,CategoryEntity category);
	
	
}
