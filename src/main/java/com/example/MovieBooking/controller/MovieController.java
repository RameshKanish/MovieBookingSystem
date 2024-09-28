package com.example.MovieBooking.controller;
import com.example.MovieBooking.dtos.MoviesDto;
import com.example.MovieBooking.models.Movies;
import com.example.MovieBooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")

public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<Movies> createBooking(@RequestBody MoviesDto mdto){
        Movies movies = movieService.createMovie(mdto.getMovieName());

        return new ResponseEntity<>(movies , HttpStatus.OK);
    }
}