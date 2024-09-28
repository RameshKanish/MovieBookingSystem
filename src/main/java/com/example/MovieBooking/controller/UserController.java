package com.example.MovieBooking.controller;


import com.example.MovieBooking.dtos.UsersDto;
import com.example.MovieBooking.models.Users;
import com.example.MovieBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<Users> createUser(@RequestBody UsersDto usersDto){
        Users user = userService.createUser(usersDto.getName() ,usersDto.getPassword() , usersDto.getEmail());
        return new ResponseEntity<>(user , HttpStatus.OK);
    }
}
