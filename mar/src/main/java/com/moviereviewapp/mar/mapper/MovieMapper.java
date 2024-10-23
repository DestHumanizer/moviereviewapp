package com.moviereviewapp.mar.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.moviereviewapp.mar.dto.GenreDetail;
import com.moviereviewapp.mar.dto.GenreRequest;
import com.moviereviewapp.mar.dto.MovieDetail;
import com.moviereviewapp.mar.dto.MovieRequest;
import com.moviereviewapp.mar.entities.GenreEntity;
import com.moviereviewapp.mar.entities.MovieEntity;

@Mapper(componentModel = "spring")
public interface MovieMapper {
	
	
	@Mapping(source = "genreRequests", target = "genres")
	MovieEntity movieRequestToMovieEntity(MovieRequest movieRequest);
	
	GenreRequest genreRequestToGenreEntity(GenreRequest genreRequest);
	
	MovieDetail movieEntityToMovieDetail(MovieEntity movieEntity);
	
	GenreDetail genreEntityToGenreDetail(GenreEntity genreEntity);
	
	

}
