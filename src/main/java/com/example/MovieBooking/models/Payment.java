package com.example.MovieBooking.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity(name = "payment")

public class Payment {
    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "booking_id" , nullable = false)
    private Booking booking;

    private Double paymentAmount;
    private String paymentStatus;

}
