package com.moviereviewapp.mar.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetail {
	
	@NotNull(message = "Id cannot be null")
	private Integer id;
	
	
	private String title;
	private String description;
	private List<GenreDetail> genreDetails;
	private LocalDateTime releaseDate;
	private LocalDateTime creationDate;
	private LocalDateTime modificationDate;
	
	

}
