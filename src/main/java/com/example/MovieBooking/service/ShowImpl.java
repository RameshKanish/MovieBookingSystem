package com.example.MovieBooking.service;

import com.example.MovieBooking.exception.MovieNotFoundException;
import com.example.MovieBooking.models.Movies;
import com.example.MovieBooking.models.Shows;
import com.example.MovieBooking.repository.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class ShowImpl implements ShowService{
    @Autowired
    private ShowsRepository showsRepository;


    @Autowired
    private MovieService movieService;

    @Override
    public Shows createShows(Time showTime , boolean showIsActive , int numberOfSeats , int movie_id) throws MovieNotFoundException{

        Movies movies = movieService.getMovieById(movie_id);
        if(movies == null){
            throw new MovieNotFoundException("Movie not found with id: " + movie_id);
        }

        Shows createdShow = null;
        Shows newShows = new Shows();
        newShows.setShow_time(showTime);
        newShows.setShowIsActive(showIsActive);
        newShows.setDeleted(false);
        newShows.setMovie(movies);
        newShows.setSeats(numberOfSeats);

        createdShow = showsRepository.save(newShows);
        return createdShow;
    }
}