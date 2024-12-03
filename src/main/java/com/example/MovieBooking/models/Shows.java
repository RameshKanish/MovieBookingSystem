package com.example.MovieBooking.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.List;

@Entity
@Data
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movies movie;

    private Time showTime;
    private boolean showIsActive;
    private boolean isDeleted;

    @OneToMany(mappedBy = "show", fetch = FetchType.LAZY)
    @JsonManagedReference // Parent side of the relationship
    private List<Seats> seats;

    // Other fields and methods
}
