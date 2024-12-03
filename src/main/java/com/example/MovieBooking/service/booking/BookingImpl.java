package com.example.MovieBooking.service.booking;

import com.example.MovieBooking.dtos.BookingDto;
import com.example.MovieBooking.models.Booking;
import com.example.MovieBooking.models.Seats;
import com.example.MovieBooking.models.Shows;
import com.example.MovieBooking.models.Users;
import com.example.MovieBooking.repository.BookingRepository;
import com.example.MovieBooking.repository.SeatRepository;
import com.example.MovieBooking.repository.ShowsRepository;
import com.example.MovieBooking.repository.UserRepository;
import com.example.MovieBooking.service.EmailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;


@Service
@Transactional

public class BookingImpl implements BookingService {

    @Autowired
    private  BookingRepository bookingRepository;

    @Autowired
    private ShowsRepository showsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public Booking createBooking(BookingDto bookingDto) throws Exception {
        try{
            System.out.println("Booking Service " + bookingDto);
            Booking booking = new Booking();

            booking.setStatus(bookingDto.getStatus());


            Shows shows = showsRepository.findById((long) bookingDto.getShow_id())
                    .orElseThrow(()-> new RuntimeException("Show Not Found"));

            Users users = userRepository.findById((long) bookingDto.getUser_id())
                            .orElseThrow(() -> new RuntimeException("User Not Found"));

            Seats seatsRepo = seatRepository.findBySeatNumberAndShowId(bookingDto.getSeatNumber() , (long) bookingDto.getShow_id());
            System.out.println("seatsRepo.................." + seatsRepo);

            if(seatsRepo == null){
                throw new RuntimeException("Seat Not Found");
            }

            if(!seatsRepo.isAvailable()){
                throw new RuntimeException("Seat " + bookingDto.getSeatNumber() + "is already booked");
            }

            booking.setUsers(users);
            booking.setShows(shows);
            Booking bookingId = bookingRepository.save(booking);

            Seats seat = new Seats();

            seat.setBooking(bookingId);
            Seats seats = seatRepository.save(seat);

            if (seats == null){
                throw new NullPointerException("Seats are not created");
            }
//            String subject = "Thank You For Your Booking...";
//
//            String body = "Hi " + users.getName() + ",\n\nYour Booking is confirmed Your Seat number is " + bookingDto.getSeatNumber();
//
//            emailService.sendMail(users.getEmail() , subject , body);

            return booking;
        }catch (Exception e) {
            throw new Exception(e);
        }
    }
}