package com.research.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.research.project.entity.OrderDetailsEntity;

@EnableJpaRepositories
public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {

}
