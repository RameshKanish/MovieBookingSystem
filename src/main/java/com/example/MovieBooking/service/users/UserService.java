package com.example.MovieBooking.service.users;

import com.example.MovieBooking.exception.EmailFoundException;
import com.example.MovieBooking.models.Users;

public interface UserService {
    public Users signUp(String userName , String  password , String email) throws EmailFoundException;
    public Boolean signIn(String  email , String password) ;
}
