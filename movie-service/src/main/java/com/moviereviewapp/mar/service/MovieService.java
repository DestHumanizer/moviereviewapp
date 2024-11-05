package com.moviereviewapp.mar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.moviereviewapp.mar.dto.MovieDetail;
import com.moviereviewapp.mar.dto.MovieRequest;

public interface MovieService {
	
	
	public Page<MovieDetail> getAllMovies(Pageable pageable);
	
	public MovieDetail createMovie(MovieRequest movieRequest);
	
	public MovieDetail getMovieById(Integer id);
	
}
