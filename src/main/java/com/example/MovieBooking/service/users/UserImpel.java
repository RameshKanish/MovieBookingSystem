package com.example.MovieBooking.service.users;

import com.example.MovieBooking.exception.EmailFoundException;
import com.example.MovieBooking.models.Users;
import com.example.MovieBooking.repository.UserRepository;
import com.example.MovieBooking.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service
public class UserImpel implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public Users signUp(String userName, String password, String email) throws EmailFoundException {
        List<Users> movieList = userRepository.findByEmail((email));

        System.out.println("movieList" + movieList);
        if(movieList.size() > 0){
            throw new EmailFoundException("Mail is already present");
        }
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
    public Boolean signIn(String  email , String password){
        Optional<Users> userOptional = userRepository.findByEmailAndPassword( email , password);
        System.out.println("UserDetails"+userOptional);
        // Check if the user is present
        if (userOptional.isPresent()) {
            return true;
        }
        return false;
    }
}