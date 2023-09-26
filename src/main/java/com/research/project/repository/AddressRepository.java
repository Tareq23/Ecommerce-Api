package com.research.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.research.project.entity.AddressEntity;
import com.research.project.projections.AddressProjection;
import com.research.project.projections.ProductProjection;
import com.research.project.security.entity.UserEntity;

@EnableJpaRepositories
public interface AddressRepository extends JpaRepository<AddressEntity, Long>{

	
	
	
	
//	@Query(nativeQuery = true)
//	List<AddressProjection> getSpecificUserAddress(Long userId);
	
	
	
	List<AddressEntity> findByUser(UserEntity user);

	@Query("select a from addresses a where a.user = ?1 and a.currentAddress = ?2")
	AddressEntity findDefaultAddressByUser(UserEntity user, boolean status);
	
	@Transactional
	@Modifying
	@Query("UPDATE addresses a SET a.currentAddress = false WHERE a.user = ?1")
	int updateDefaultAddressFalse(UserEntity user);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE addresses a SET a.currentAddress = true WHERE a.id = ?1")
	int updateDefaultAddressTrue(Long addressId);
	
	
}
