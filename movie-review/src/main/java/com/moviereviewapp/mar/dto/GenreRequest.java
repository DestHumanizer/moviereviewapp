package com.moviereviewapp.mar.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreRequest {
	
	
	@NotEmpty(message = "Title must not be empty")
	@Size(max = 20, message = "Title must contain max 20 characters")
	private String title;
	
	
	@NotEmpty(message = "Description must nmot be empty")
	@Size(min = 10, max = 1000, message = "Description must not be empty")
	private String description;

}
