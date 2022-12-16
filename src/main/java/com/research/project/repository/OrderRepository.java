package com.research.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.research.project.entity.OrderDetailsEntity;
import com.research.project.entity.OrderEntity;
import com.research.project.security.entity.UserEntity;

@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

//	@Query("SELECT o FROM orders o WHERE o.user_id = ?1")
//	List<OrderEntity> getUserOrder(Long id);
	@Query(value = "SELECT * FROM orders o WHERE o.user_id = :id order by o.id desc", nativeQuery = true)
	List<OrderEntity> getUserOrder(Long id);
	
	
	@Transactional
	@Modifying
	@Query(value = "update orders o set o.order_status = :orderStatus where o.id = :id", nativeQuery = true)
	int updateOrderStatus(Long id, String orderStatus);
	
//	@Query("SELECT o.details FROM orders o WHERE o.user = ?1 and WHERE o.paymentStatus = ?2")
	@Query("SELECT o.details FROM orders o WHERE o.user = ?1")
	List<OrderEntity> unreviewedOrder(UserEntity user, String paymentStatus);
	
	List<OrderEntity> findByUserAndPaymentStatus(UserEntity user, String paymentStatus);
	
	
}
