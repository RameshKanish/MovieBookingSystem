package com.example.MovieBooking.controller;

import com.example.MovieBooking.dtos.ShowsDto;
import com.example.MovieBooking.exception.MovieNotFoundException; 
import com.example.MovieBooking.models.Shows;
import com.example.MovieBooking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")

public class ShowController {
    @Autowired
    private  ShowService showService;

    @PostMapping("/createShow")
    public ResponseEntity<Shows> createShows(@RequestBody ShowsDto showsDto)throws MovieNotFoundException {

        Shows show = showService.createShows(showsDto.getShow_time() , showsDto.isShowIsActive() , showsDto.getNumberOfSeats() , showsDto.getMovie_id());
        if(show == null){
            throw new NullPointerException();
        }
        return new ResponseEntity<>(show , HttpStatus.OK);
    }
}