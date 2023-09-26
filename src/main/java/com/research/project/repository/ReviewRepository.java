package com.research.project.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.research.project.entity.ProductEntity;
import com.research.project.entity.ReviewEntity;
import com.research.project.projections.ProductProjection;
import com.research.project.projections.ReviewProjection;
import com.research.project.security.entity.UserEntity;

@EnableJpaRepositories
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>{

	
	

	
	@Query("select new com.research.project.projections.ReviewProjection(r, r.product) from reviews r where r.user = ?1")
	List<ReviewProjection> reviewfindByUser(UserEntity user);
	
	
	
	
//	@Query("select r, r.product.name from reviews r where r.user = ?1")
//	List<ReviewEntity> reviewfindByUser(UserEntity user);
	
}
