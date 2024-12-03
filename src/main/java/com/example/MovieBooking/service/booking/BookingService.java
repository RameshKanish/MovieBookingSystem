package com.example.MovieBooking.service.booking;

import com.example.MovieBooking.dtos.BookingDto;
import com.example.MovieBooking.models.Booking;

public interface BookingService {
    public Booking createBooking(BookingDto bookingDto) throws Exception;
}