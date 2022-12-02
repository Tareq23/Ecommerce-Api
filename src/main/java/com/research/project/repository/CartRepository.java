package com.research.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.research.project.entity.CartEntity;

@EnableJpaRepositories
public interface CartRepository extends JpaRepository<CartEntity, Long>{

}
