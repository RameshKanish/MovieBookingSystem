package com.example.MovieBooking.dtos;


import lombok.Data;

import java.util.UUID;

@Data
public class BookingDto {
    private int user_id;
    private int show_id;
    private String status;
    private String seatNumber;
}