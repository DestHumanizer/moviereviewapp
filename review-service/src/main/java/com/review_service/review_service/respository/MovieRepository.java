package com.review_service.review_service.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.review_service.review_service.entities.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{
	
	Page<MovieEntity> findByMovieId(Integer movieId, Pageable pageable);

}
