package com.example.MovieBooking.service.shows;

import com.example.MovieBooking.exception.MovieNotFoundException;
import com.example.MovieBooking.models.Movies;
import com.example.MovieBooking.models.Seats;
import com.example.MovieBooking.models.Shows;
import com.example.MovieBooking.repository.SeatRepository;
import com.example.MovieBooking.repository.ShowsRepository;
import com.example.MovieBooking.service.movies.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowImpl implements ShowService {
    @Autowired
    private ShowsRepository showsRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private MovieService movieService;

    @Override
    public Shows createShows(Time showTime, boolean showIsActive, int numberOfSeats, int movie_id) throws MovieNotFoundException {
        // Fetch the movie object using the provided movie_id
        Movies movies = movieService.getMovieById(movie_id);
        if (movies == null) {
            throw new MovieNotFoundException("Movie not found with id: " + movie_id);
        }

        // Create new Show object
        Shows newShows = new Shows();
        newShows.setShowTime(showTime);
        newShows.setShowIsActive(showIsActive);
        newShows.setDeleted(false);
        newShows.setMovie(movies);

        // Create a list to hold the seats
        List<Seats> seatsList = new ArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            Seats seat = new Seats();
            seat.setSeatNumber("Seat-" + i);
            seat.setAvailable(true);
            seat.setShow(newShows);  // Assigning the show to the seat
            seatsList.add(seat);  // Add each seat to the list
        }

        // Set the seats list to the Show
        newShows.setSeats(seatsList);

        // Save the show and the seats
        showsRepository.save(newShows);  // Save the show object
        seatRepository.saveAll(seatsList);  // Save all the seats at once

        return newShows;
    }

}