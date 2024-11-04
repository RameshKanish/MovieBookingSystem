package com.example.MovieBooking.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;


@Entity(name = "booking")
@Data
public class Booking {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "show_id" , nullable = false)
    private Shows shows ;

    @OneToOne(mappedBy = "booking")
    private Payment payment;

    private String status;
    private Timestamp created_at;
    private boolean isDeleted ;
}