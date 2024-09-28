package com.example.MovieBooking.repository;

import com.example.MovieBooking.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsRepository extends JpaRepository<Shows , Long> { }