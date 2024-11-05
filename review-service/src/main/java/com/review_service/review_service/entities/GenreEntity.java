package com.review_service.review_service.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class GenreEntity extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int genreId;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "genre")
	private List<MovieGenreEntity> movieGenres;

}
