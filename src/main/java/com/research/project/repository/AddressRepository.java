package com.research.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.research.project.entity.AddressEntity;
import com.research.project.projections.AddressProjection;
import com.research.project.projections.ProductProjection;

@EnableJpaRepositories
public interface AddressRepository extends JpaRepository<AddressEntity, Long>{

	
	
	
	
	@Query(nativeQuery = true)
	List<AddressProjection> getSpecificUserAddress(Long userId);
	
	
}
