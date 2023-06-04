package com.example.MovieDatabase.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.MovieDatabase.models.Movie;
import com.example.MovieDatabase.repository.MovieRepository;
import com.example.MovieDatabase.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	
	private final MovieRepository movieRepository;


	public MovieServiceImpl(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@Override
	public Optional<Movie> findById(Long id) {
		
		return movieRepository.findById(id);
	}

	@Override
	public List<Movie> findAll() {
		
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> findByGenre(String genre) {
		
		return movieRepository.findByGenre(genre);
	}
	
}
