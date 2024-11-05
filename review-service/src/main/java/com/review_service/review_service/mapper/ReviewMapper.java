package com.review_service.review_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.review_service.review_service.dto.ReviewDetail;
import com.review_service.review_service.dto.ReviewRequest;
import com.review_service.review_service.entities.MovieEntity;
import com.review_service.review_service.entities.ReviewEntity;
import com.review_service.review_service.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
	
	@Mapping(target = "reviewId", ignore = true)
	@Mapping(target = "user", source = "userEntity")
	@Mapping(target = "movie", source = "movieEntity")
	@Mapping(target = "rating", source = "reviewRequest.rating")
	@Mapping(target = "reviewText", source = "reviewRequest.reviewText")
	ReviewEntity reviewRequestToReviewEntity(
			ReviewRequest reviewRequest,
			UserEntity userEntity,
			MovieEntity movieEntity);
	
	@Mapping(target = "id", source = "reviewId")
	@Mapping(target = "userId", source = "user.userId")
	@Mapping(target = "movieId", source = "movie.movieId")
	ReviewDetail reviewEntityToReviewDetail(ReviewEntity reviewEntity);
	
	

}
