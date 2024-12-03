package com.example.MovieBooking.dtos;

import com.example.MovieBooking.models.Movies;
import com.example.MovieBooking.models.Seats;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.List;


@Data
public class ShowsDto {
    private Time show_time;
    private boolean showIsActive;
    private int numberOfSeats;
    private int movie_id;
}