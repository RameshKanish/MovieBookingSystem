package com.example.MovieBooking.dtos;

import com.example.MovieBooking.models.Movies;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;


@Data
public class ShowsDto {
    private Time show_time;
    private boolean showIsActive;
}
