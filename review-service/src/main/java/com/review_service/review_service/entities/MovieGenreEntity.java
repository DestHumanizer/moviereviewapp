package com.review_service.review_service.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MovieGenreEntity extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieGenreId;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private MovieEntity movie;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private GenreEntity genre;

}
