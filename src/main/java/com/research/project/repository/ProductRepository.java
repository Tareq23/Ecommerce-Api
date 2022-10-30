package com.research.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.research.project.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
////	@Query("select p from ProductEntity p where p.id =:id")
//	@Query(value="select * from products", nativeQuery = true)
////	Optional<ProductEntity> findProductById(@Param("id") Long id);
//	Optional<ProductEntity> findProductById();
//	
//	@Query(value="select * from products", nativeQuery = true)
//	List<ProductEntity> findAllProducts();
	
}
