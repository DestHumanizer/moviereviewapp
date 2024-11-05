package com.moviereviewapp.mar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereviewapp.mar.entities.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
	
	boolean existsByTitle(String title);

}
