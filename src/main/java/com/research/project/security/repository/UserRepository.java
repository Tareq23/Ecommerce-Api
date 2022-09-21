package com.research.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.project.security.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
}
