package com.example.MovieDatabase.service;

import java.util.List;
import java.util.Optional;

import com.example.MovieDatabase.models.Movie;


public interface MovieService {
	
	Optional<Movie> findById(Long id);
	
	List<Movie> findByGenre(String genre);

    List<Movie> findAll();

 

}
