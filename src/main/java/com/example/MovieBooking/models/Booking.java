package com.example.MovieBooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

public class Booking {

    private long id;
    private long user_id;
    private long show_id ;
    private String status;
    private Timestamp created_at;
    private boolean isDeleted ;
}
