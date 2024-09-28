package com.example.MovieBooking.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;


@Entity(name = "booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "show_id" , nullable = false)
    private Shows shows ;


    private String status;
    private Timestamp created_at;
    private boolean isDeleted ;
}