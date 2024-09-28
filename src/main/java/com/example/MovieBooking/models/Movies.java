package com.example.MovieBooking.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity(name = "movies")
@Data // Lombok annotation
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String movieName;
    private boolean isDeleted;
}