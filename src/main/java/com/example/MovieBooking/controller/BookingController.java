package com.example.MovieBooking.controller;


import com.example.MovieBooking.dtos.BookingDto;
import com.example.MovieBooking.models.Booking;
import com.example.MovieBooking.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")

public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/createBooking")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDto bookingDto) throws Exception{
        System.out.println(bookingDto);
        Booking booking = bookingService.createBooking(bookingDto);
        return new ResponseEntity<Booking>(HttpStatus.CREATED);
    }
}