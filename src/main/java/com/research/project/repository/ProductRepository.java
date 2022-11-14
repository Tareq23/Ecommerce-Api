package com.research.project.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;

import com.research.project.entity.CategoryEntity;
import com.research.project.entity.ProductEntity;
import com.research.project.model.ProductModel;
import com.research.project.projections.ProductDTO;

@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
	
//	@Query(nativeQuery = true, value = "SELECT new com.research.project.model.ProductModel( p.id, p.name, p.price, p.imageUrl, p.description, c.name as categoryName, c.id as categoryId) from products p inner join categories c on p.category_id = c.id where p.id=?1")
//	@Query("SELECT new com.research.project.model.ProductModel( p.id, p.name, p.price, p.imageUrl, p.description, c.name as categoryName, c.id as categoryId) from products p inner join categories c on p.category_id = c.id where p.id=?1")
	
//	@Query(nativeQuery = true, value="SELECT new com.research.project.model.ProductModel(p.id, p.name, p.imageUrl, p.description,  p.category_id as categoryId) from products p where p.id=?1")
//	public ProductModel findByProductId(Long id);
	
	@Query(nativeQuery = true)
	ProductDTO getSingleProductById(Long id);
	
	@Transactional
	@Modifying
	@Query(value="update products p set p.name = :name, p.price = :price, p.description = :description, p.image_url = :imageUrl, p.category_id = :categoryId where p.id = :id",nativeQuery = true)
	int updateProduct(@Param("id") Long id, @Param("name") String name, 
			@Param("price") float price,
			@Param("description") String description,
			@Param("imageUrl") String imageUrl,
			@Param("categoryId") Long categoryId );
	
}
