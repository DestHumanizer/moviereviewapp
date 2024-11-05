package com.moviereviewapp.mar.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
	
	private Integer id;
	
	@NotEmpty(message = "Title of the movie cannot be empty")
	@Size(max = 20, message = "Title of the movie cannot be longer than 20 characters")
	private String title;
	
	@NotEmpty(message = "Movie description cannot be empty")
	@Size(min = 10, max = 500, message = "Movie description must be between 10 and 500 characters")
	private String description;
	
	@NotEmpty(message = "Movie genre cannot be empty")
	private List<GenreRequest> genreRequests;
	
	
	private LocalDateTime releaseDate;
	
	

}
