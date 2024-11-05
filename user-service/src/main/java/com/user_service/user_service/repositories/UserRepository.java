package com.user_service.user_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user_service.user_service.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	boolean existsByEmail(String email);
	

}
