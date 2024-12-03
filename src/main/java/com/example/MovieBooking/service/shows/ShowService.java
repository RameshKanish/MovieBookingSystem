package com.example.MovieBooking.service.shows;

import com.example.MovieBooking.exception.MovieNotFoundException;
import com.example.MovieBooking.models.Seats;
import com.example.MovieBooking.models.Shows;

import java.sql.Time;
import java.util.List;

public interface ShowService {
    public Shows createShows(Time showTime , boolean showIsActive , int numberOfSeats , int movie_id) throws MovieNotFoundException;
}