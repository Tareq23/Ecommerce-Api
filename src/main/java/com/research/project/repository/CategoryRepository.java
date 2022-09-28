package com.research.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.project.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	
}
