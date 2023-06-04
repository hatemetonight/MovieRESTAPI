package com.example.MovieDatabase.controllers;


import java.util.List;
import java.util.Optional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieDatabase.service.MovieService;
import com.example.MovieDatabase.Request.AddMovie;
import com.example.MovieDatabase.models.Movie;
import com.example.MovieDatabase.repository.MovieRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(value="Работа с фильмами", description="")
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	private MovieRepository movierepository;
	
	@Autowired
	private MovieService movieService;


	@GetMapping("/all/movies")
	@ApiOperation(value = "Список всех фильмов", response = List.class)
	public ResponseEntity<?> allAccess() {
			List<Movie> movie = movierepository.findAll();
			return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@PostMapping("/user/addmovie")
	@ApiOperation(value = "Добавить фильм", response = List.class)
	public ResponseEntity<?> addMovie(@RequestBody AddMovie movie) throws Exception {		
		Movie newMovie = new Movie(movie.getTitle(),movie.getGenre(),movie.getDetails(),movie.getRelease_date(),0.0f);		
		movierepository.save(newMovie);
		return new ResponseEntity<>("Movie Added Successfully", HttpStatus.OK);
	}

	@GetMapping("/user/getmovie")
	@ApiOperation(value = "Получить информацию о фильме по ID", response = List.class)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getMoviesforUser(@RequestParam long id) {
		Optional<Movie> movie = movierepository.findById(id);
		return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}
