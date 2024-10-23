package com.moviereviewapp.mar.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moviereviewapp.mar.dto.MovieDetail;
import com.moviereviewapp.mar.dto.MovieRequest;
import com.moviereviewapp.mar.service.MovieService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MovieController {
	
	private final MovieService movieService;
	
	public MovieDetail createMovie(@RequestBody @Valid MovieRequest movieRequest) {
		return movieService.createMovie(movieRequest);
	}
	
	@GetMapping("/movie/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MovieDetail getMovieById(@PathVariable Integer id) {
		return movieService.getMovieById(id);
	}
	
	
	@GetMapping
	public Page<MovieDetail> getAllMovies(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		PageRequest pageable = PageRequest.of(page, size);
		
		return movieService.getAllMovies(pageable);
	}

}
