package com.review_service.review_service.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.review_service.review_service.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
