package com.example.MovieBooking.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;


@Entity(name = "users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;

    @Column(nullable = false)
    private String password;

    private Timestamp created_at;
}