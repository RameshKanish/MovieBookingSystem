package com.example.MovieBooking.service;

import com.example.MovieBooking.models.Movies;

import java.util.List;

public interface MovieService {
    public Movies createMovie(String movieName);
    public List<Movies> getAllMovies();
}
