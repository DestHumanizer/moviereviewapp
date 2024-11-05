package com.review_service.review_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.review_service.review_service.dto.ReviewDetail;
import com.review_service.review_service.dto.ReviewRequest;
import com.review_service.review_service.entities.MovieEntity;
import com.review_service.review_service.entities.ReviewEntity;
import com.review_service.review_service.entities.UserEntity;
import com.review_service.review_service.exceptions.MovieNotFoundException;
import com.review_service.review_service.exceptions.ReviewNotFoundException;
import com.review_service.review_service.exceptions.UserNotFoundException;
import com.review_service.review_service.mapper.ReviewMapper;
import com.review_service.review_service.respository.MovieRepository;
import com.review_service.review_service.respository.ReviewRepository;
import com.review_service.review_service.respository.UserRepository;
import com.review_service.review_service.service.ReviewService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private final ReviewRepository reviewRepository;
	
	@Autowired
	private final MovieRepository movieRepository;
	
	@Autowired
	private final UserRepository userRepository;
	
	@Autowired
	private final ReviewMapper reviewMapper;
	
	@Value("${properties.messages.error.movie-does-not-exist}")
	private String movieNotFoundError;
	
	@Value("${properties.messages.error.review-does-not-exist}")
	private String reviewNotFoundError;

	@Override
	public ReviewDetail createReview( 
			Integer movieId,
			ReviewRequest reviewRequest) {
		// TODO Auto-generated method stub
		
		MovieEntity movieEntity = movieRepository.findById(movieId)
			.orElseThrow(() -> new MovieNotFoundException(
					String.valueOf(HttpStatus.NOT_FOUND.value()),
					movieNotFoundError));
		
		
		UserEntity userEntity = userRepository.findById(movieId)
				.orElseThrow(() -> new UserNotFoundException(
						String.valueOf(HttpStatus.NOT_FOUND.value()),
						movieNotFoundError));
		
		ReviewEntity reviewEntity = reviewMapper.reviewRequestToReviewEntity(
				reviewRequest,
				userEntity,
				movieEntity);
		
		
		
		
		ReviewEntity reviewEntitySaved = reviewRepository.save(reviewEntity);
		
		return reviewMapper.reviewEntityToReviewDetail(reviewEntity);
		
	}

	@Override
	public Page<ReviewDetail> getAllReviews(Integer movieId, Pageable pageable) {
		// TODO Auto-generated method stub
		
		movieRepository.findById(movieId)
				.orElseThrow(
						() -> new MovieNotFoundException(
								String.valueOf(HttpStatus.NOT_FOUND.value()), movieNotFoundError));
		
		Page<ReviewEntity> reviewsPage = reviewRepository.findByReviewId(movieId, pageable);
		
		return reviewsPage.map(review -> reviewMapper.reviewEntityToReviewDetail(review));
		
	}

	@Override
	public ReviewDetail updateReview(Integer reviewId, ReviewRequest reviewRequest) {
		// TODO Auto-generated method stub
		ReviewEntity reviewEntity =
		reviewRepository.findById(reviewId)
		.orElseThrow(() -> new UserNotFoundException(
				String.valueOf(HttpStatus.NOT_FOUND.value()), reviewNotFoundError));
		
		UserEntity userEntity = reviewEntity.getUser();
		
		MovieEntity movieEntity = reviewEntity.getMovie();
		
		ReviewEntity reviewModified = reviewMapper
				.reviewRequestToReviewEntity(
						reviewRequest,
						userEntity,
						movieEntity);
		
		return reviewMapper.reviewEntityToReviewDetail(reviewModified);
		

	}

	@Override
	public void deleteReview(Integer reviewId) {
		// TODO Auto-generated method stub
		
		ReviewEntity reviewEntity =
				reviewRepository.findById(reviewId)
				.orElseThrow(
						() -> new ReviewNotFoundException(
								String.valueOf(HttpStatus.NOT_FOUND.value()),
								reviewNotFoundError));
		
		reviewRepository.delete(reviewEntity);
	
		
		
		
	}
	

	

}
