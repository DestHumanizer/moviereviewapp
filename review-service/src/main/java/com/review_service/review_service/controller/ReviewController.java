package com.review_service.review_service.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review_service.review_service.dto.ReviewDetail;
import com.review_service.review_service.dto.ReviewRequest;
import com.review_service.review_service.service.ReviewService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReviewController {
	
	
	private final ReviewService reviewService;
	
	@PostMapping("/movies/{movieId}/reviews")
	public ReviewDetail createReview(
			@RequestBody @Valid ReviewRequest reviewRequest,
			@PathVariable Integer movieId) {
		return reviewService.createReview(movieId, reviewRequest);
	}
	
	@GetMapping("/movies/{movieId}/reviews")
	public Page<ReviewDetail> getAllReviews(
			@PathVariable Integer movieId,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		PageRequest pageable = PageRequest.of(page, size);
		
		
		Page<ReviewDetail> reviewDetails = reviewService.getAllReviews(
				movieId, pageable);
		
		return reviewDetails;
		
	}
	
	@PutMapping("/reviews/{reviewId}")
	public ReviewDetail updateReview(
			@PathVariable Integer reviewId,
			@RequestBody @Valid ReviewRequest reviewRequest) {
		
		return reviewService.updateReview(reviewId, reviewRequest);
		
	}
	
	@DeleteMapping("/reviews/{reviewId}")
	public void deleteReview(
			@PathVariable Integer reviewId) {
		
		reviewService.deleteReview(reviewId);
	}
	

}
