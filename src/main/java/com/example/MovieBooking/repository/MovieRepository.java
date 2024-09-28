package com.example.MovieBooking.repository;

import com.example.MovieBooking.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <Movies, Integer>{ }