package com.example.MovieBooking.service;

import com.example.MovieBooking.exception.EmailFoundException;
import com.example.MovieBooking.models.Users;

public interface UserService {
    public Users createUser(String userName , String  password , String email) throws EmailFoundException;
}
