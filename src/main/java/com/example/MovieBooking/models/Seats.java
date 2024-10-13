package com.example.MovieBooking.models;

import jakarta.persistence.*;


@Entity
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String  seatNumber;
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Shows shows;
}