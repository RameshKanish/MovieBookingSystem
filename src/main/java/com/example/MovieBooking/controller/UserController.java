package com.example.MovieBooking.controller;


import com.example.MovieBooking.dtos.UsersDto;
import com.example.MovieBooking.exception.EmailFoundException;
import com.example.MovieBooking.models.Users;
import com.example.MovieBooking.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<Users> createUser(@RequestBody UsersDto usersDto) throws EmailFoundException {
        Users user = userService.createUser(usersDto.getName() ,usersDto.getPassword() , usersDto.getEmail());
        return new ResponseEntity<>(user , HttpStatus.OK);
    }


    @PostMapping("/signIn")
    public ResponseEntity<Boolean> signIn(@RequestBody UsersDto usersDto){
        boolean isValidUser = userService.signIn(usersDto.getEmail() , usersDto.getPassword());
        if(isValidUser){
            return new ResponseEntity<>(isValidUser , HttpStatus.OK);
        }
        return new ResponseEntity<>(isValidUser , HttpStatus.NOT_ACCEPTABLE);
    }
}