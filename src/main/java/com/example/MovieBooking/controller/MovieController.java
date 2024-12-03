package com.example.MovieBooking.controller;
import com.example.MovieBooking.dtos.MoviesDto;
import com.example.MovieBooking.models.Movies;
import com.example.MovieBooking.service.movies.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<Object> createMovie(@RequestBody MoviesDto mdto){
        Movies movies = movieService.createMovie(mdto.getMovieName());
        if(movies == null){
            return new ResponseEntity<>("Already movie exists", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(movies , HttpStatus.OK);
    }


    @GetMapping("/getAllMovies")
    public ResponseEntity<List<Movies>> getAllMovies(){
        List<Movies> movie =movieService.getAllMovies();
        return  new ResponseEntity<>(movie , HttpStatus.ACCEPTED);
    }
}