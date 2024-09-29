package com.example.MovieBooking.advice;

import com.example.MovieBooking.exception.MovieNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdvice {
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> getMovieException(MovieNotFoundException movie){
        return new ResponseEntity<>(movie.getMessage() , HttpStatusCode.valueOf(400));
    }
}