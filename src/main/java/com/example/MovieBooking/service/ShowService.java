package com.example.MovieBooking.service;

import com.example.MovieBooking.exception.MovieNotFoundException;
import com.example.MovieBooking.models.Shows;

import java.sql.Time;

public interface ShowService {
    public Shows createShows(Time showTime , boolean showIsActive , int numberOfSeats) throws MovieNotFoundException;
}