package com.example.MovieBooking.service;

import com.example.MovieBooking.models.Users;
import com.example.MovieBooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;


@Service
public class UserImpel implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public Users createUser(String userName, String password, String email) {
        Users users = new Users();
        users.setName(userName);
        users.setEmail(email);
        users.setPassword(password);
        users.setCreated_at(Timestamp.from(Instant.now()));
        userRepository.save(users);

        String subject = "Welcome to Ramesh Booking";

        String body = "Hi " + userName + ",\n\nWelcome to MovieBooking! Your account has been created successfully.";

        emailService.sendMail(email , subject , body);

        return users;
    }
}
