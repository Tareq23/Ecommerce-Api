package com.research.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.project.security.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findByName(String name);
}
