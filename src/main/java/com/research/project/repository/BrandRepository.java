package com.research.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.research.project.entity.BrandEntity;

@EnableJpaRepositories
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}
