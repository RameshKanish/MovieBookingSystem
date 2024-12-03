package com.example.MovieBooking.service.movies;

import com.example.MovieBooking.exception.MovieNotFoundException;
import com.example.MovieBooking.models.Movies;
import com.example.MovieBooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieImpl implements MovieService {
    @Autowired
    MovieRepository mr;

    @Override
    public Movies createMovie(String movieName) {
        Movies movies = mr.findByMovieName(movieName);

        if(movies != null){
            return movies;
        }
        Movies movie = new Movies();  // Create a new Movies object
        movie.setMovieName(movieName); // Set the movie name
        return mr.save(movie);
    }

    public List<Movies> getAllMovies(){
        return mr.findAll();
    }

    public Movies getMovieById(int movie_id) throws MovieNotFoundException {
        return mr.findById(movie_id).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
    }
}