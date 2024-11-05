package com.review_service.review_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDetail {
	
	private int id;
	
	private int movieId;
	
	private int userId;
	
	private int rating;
	
	private String reviewText;
	
	private LocalDateTime creationDate;
	
	private LocalDateTime modificationDate;
	
	

}
