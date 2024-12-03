package com.example.MovieBooking.service.movies;

import com.example.MovieBooking.exception.MovieNotFoundException;
import com.example.MovieBooking.models.Movies;

import java.util.List;

public interface MovieService {
    public Movies createMovie(String movieName);
    public List<Movies> getAllMovies();
    public Movies getMovieById(int movie_id) throws MovieNotFoundException;
}
