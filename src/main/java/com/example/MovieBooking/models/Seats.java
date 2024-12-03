package com.example.MovieBooking.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String seatNumber;
    private boolean isAvailable;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "show_id")
    @JsonBackReference // Prevent recursive serialization to 'show' in Shows entity
    private Shows show;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "booking_id")
    @JsonBackReference // Prevent recursive serialization to 'booking' in Booking entity
    private Booking booking;
}