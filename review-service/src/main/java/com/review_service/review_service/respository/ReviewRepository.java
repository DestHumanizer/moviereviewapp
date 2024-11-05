package com.review_service.review_service.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.review_service.review_service.entities.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
	
	Page<ReviewEntity> findByReviewId(Integer reviewId, Pageable pageable);
	
	

}
