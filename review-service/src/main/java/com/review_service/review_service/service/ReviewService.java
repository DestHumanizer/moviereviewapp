package com.review_service.review_service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.review_service.review_service.dto.ReviewDetail;
import com.review_service.review_service.dto.ReviewRequest;

public interface ReviewService {
	
	//POST
	public ReviewDetail createReview(Integer id, ReviewRequest reviewRequest);
	
	//GET ALL
	public Page<ReviewDetail> getAllReviews(Integer id, Pageable pageable);
	
	//PUT
	public ReviewDetail updateReview(Integer reviewId, ReviewRequest reviewRequest);
	
	//DELETE
	public void deleteReview(Integer reviewId);

}
