package com.moviereviewapp.mar.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.moviereviewapp.mar.dto.MovieDetail;
import com.moviereviewapp.mar.dto.MovieRequest;
import com.moviereviewapp.mar.entities.MovieEntity;
import com.moviereviewapp.mar.exceptions.ConflictException;
import com.moviereviewapp.mar.exceptions.MovieNotFoundException;
import com.moviereviewapp.mar.mapper.MovieMapper;
import com.moviereviewapp.mar.repository.MovieRepository;
import com.moviereviewapp.mar.service.MovieService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
	
	private final MovieRepository movieRepository;
	
	private final MovieMapper movieMapper;
	
	@Value("${properties.messages.error.movie-does-not-exist}")
	private String movieDoesntExistError;
	
	@Value("${properties.messages.error.movie-already-exists}")
	private String movieAlreadyExistsError;
	
	

	@Override
	public Page<MovieDetail> getAllMovies(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<MovieEntity> movieEntities = movieRepository.findAll(pageable);
		
		return movieEntities.map(
				movieMapper::movieEntityToMovieDetail);
	}

	@Override
	public MovieDetail createMovie(MovieRequest movieRequest) {
		// TODO Auto-generated method stub
		
		if(movieRepository.existsByTitle(movieRequest.getTitle())) {
			throw new ConflictException(String.valueOf(HttpStatus.CONFLICT.value()), movieAlreadyExistsError);
			
		}
		
		MovieEntity movieEntity = movieMapper.movieRequestToMovieEntity(movieRequest);
		MovieEntity movieEntitySaved = movieRepository.save(movieEntity);
		
		
		return movieMapper.movieEntityToMovieDetail(movieEntitySaved);
	}

	@Override
	public MovieDetail getMovieById(Integer id) {
		// TODO Auto-generated method stub
		
		MovieEntity movieEntity = movieRepository.findById(id)
				.orElseThrow(() -> new MovieNotFoundException(
						String.valueOf(HttpStatus.NOT_FOUND.value()), movieDoesntExistError));
		
		return movieMapper.movieEntityToMovieDetail(movieEntity);
		
	}
	
	
	
	

}
