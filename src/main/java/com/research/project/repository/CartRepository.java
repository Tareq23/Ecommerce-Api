package com.research.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.research.project.entity.CartEntity;
import com.research.project.security.entity.UserEntity;

@EnableJpaRepositories
public interface CartRepository extends JpaRepository<CartEntity, Long>{
	
	
	@Transactional
	@Modifying
    @Query("DELETE carts c WHERE c.id = ?1")
    void deleteByCartId(Long cartId);
	
	
	@Transactional
	@Modifying
    @Query("DELETE carts c WHERE c.user = ?1")
    void deleteByUser(UserEntity user);

}
