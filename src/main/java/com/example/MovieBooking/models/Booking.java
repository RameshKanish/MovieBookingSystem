package com.example.MovieBooking.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


@Entity(name = "booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id" , nullable = false)
    @JsonBackReference
    private Shows shows ;

    @OneToOne(mappedBy = "booking" ,fetch = FetchType.LAZY)
    private Payment payment;

    private String status;

    @CreationTimestamp
    private Timestamp created_at;

    private boolean isDeleted ;
}