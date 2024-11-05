package com.review_service.review_service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
	
	@NotEmpty(message = "rating cannot be empty")
	@Size(max = 5, min = 1, message = "Rating must be between 1 and 5")
	private int rating;
	
	@NotEmpty(message = "review text cannot be empty")
	@Size(max = 200, min = 20, message = "review text must be between 20 and 200 characters")
	private String reviewText;

}
