package com.review_service.review_service.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class MovieEntity extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int movieId;
	
	@Column(name = "title", length = 20, nullable = false)
	private String title;
	
	@Column(name = "description", length = 200, nullable = false)
	private String description;
	
	@Column(name = "releaseDate")
	private LocalDateTime releaseDate;
	
	@OneToMany(fetch = FetchType.LAZY)
	@Column(name = "movie_genre_id", nullable = false)
	private List<MovieGenreEntity> movieGenres;

}
