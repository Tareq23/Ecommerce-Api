package com.research.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.project.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
