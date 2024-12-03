package com.example.MovieBooking.controller;


import com.example.MovieBooking.dtos.UsersDto;
import com.example.MovieBooking.exception.EmailFoundException;
import com.example.MovieBooking.models.Users;
import com.example.MovieBooking.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> createUser(@RequestBody UsersDto usersDto) throws EmailFoundException {
        try{
            Users user = userService.signUp(usersDto.getName() ,usersDto.getPassword() , usersDto.getEmail());
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch (EmailFoundException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/signIn")
    public ResponseEntity<Map> signIn(@RequestBody UsersDto usersDto){

        boolean isValidUser = userService.signIn(usersDto.getEmail() , usersDto.getPassword());
        Map<String, String> response = new HashMap<>();
        if (isValidUser) {
            response.put("status", "Success");
            response.put("message", "Sign-in successful");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status", "Failure");
            response.put("message", "Sign-in failed");
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}