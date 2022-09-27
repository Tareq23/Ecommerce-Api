package com.research.project.security.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.project.security.entity.CheckEntity;

public interface CheckRepository extends JpaRepository<CheckEntity, Serializable>{

}
