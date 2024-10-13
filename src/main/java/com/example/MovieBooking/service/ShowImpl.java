package com.example.MovieBooking.service;

import com.example.MovieBooking.exception.MovieNotFoundException;
import com.example.MovieBooking.models.Movies;
import com.example.MovieBooking.models.Shows;
import com.example.MovieBooking.repository.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;


@Service
public class ShowImpl implements ShowService{
    @Autowired
    private ShowsRepository showsRepository;


    @Autowired
    private MovieService movieService;

    @Override
    public Shows createShows(Time showTime , boolean showIsActive , int numberOfSeats) throws MovieNotFoundException{
        List<Movies> moviesList = movieService.getAllMovies();

        if(moviesList.isEmpty()){
            throw new MovieNotFoundException("MovieNot found");
        }


        Shows createdShow = null;
        Shows newShows = new Shows();
        newShows.setShow_time(showTime);
        newShows.setShowIsActive(showIsActive);
        newShows.setDeleted(false);

        createdShow = showsRepository.save(newShows);
        return createdShow;
    }
}