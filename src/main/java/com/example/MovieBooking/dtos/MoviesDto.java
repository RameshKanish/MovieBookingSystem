package com.example.MovieBooking.dtos;

import com.example.MovieBooking.models.Shows;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
public class MoviesDto {
    private String movieName;
    private boolean isDeleted;
}
