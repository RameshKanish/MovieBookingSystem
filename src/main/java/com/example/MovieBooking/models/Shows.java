package com.example.MovieBooking.models;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Time;
import java.util.List;

@Entity(name = "shows")
@Data // Lombok annotation to generate getters, setters, etc.
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne // Many shows can belong to one movie
    @JoinColumn(name = "movie_id") // Foreign key to the Movies table
    private Movies movie; // Changed from 'movies' to 'movie'

    private Time show_time;
    private boolean showIsActive; // Fixed typo: 'showIsActice' to 'showIsActive'
    private boolean isDeleted;


    @OneToMany
    private List<Seats> seats;
}