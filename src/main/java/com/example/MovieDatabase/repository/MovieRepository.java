package com.example.MovieDatabase.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.MovieDatabase.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	//Fetch movie by movie_id
	@Query(value ="select * from movie where id= ?1",nativeQuery=true) 
	Optional<Movie> findById(long id);
	
	//Fetch movie by genre
	@Query(value ="select * from movie where genre= ?1",nativeQuery=true) 
	List<Movie> findByGenre(String genre);

}
