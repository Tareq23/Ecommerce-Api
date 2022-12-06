package com.research.project.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.research.project.entity.ProductEntity;
import com.research.project.entity.ReviewEntity;
import com.research.project.projections.ProductProjection;

@EnableJpaRepositories
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>{

	
	
////	@Query(value="select com.research.project.entity.ReviewEntity(r.id, r.rating_number, r.details, r.reviewImage) from reviews r where r.product_id = :product", nativeQuery = true)
//	@Query("select com.research.project.entity.ReviewEntity(r.id, r.ratingNumber, r.details, r.reviewImage) from reviews r where r.product = :product")
////	List<ReviewEntity> getProductReviewByProductId(Long product);
//	List<ReviewEntity> getProductReviewByProductId(ProductEntity product);
	
}
