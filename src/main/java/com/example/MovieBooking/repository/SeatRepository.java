package com.example.MovieBooking.repository;

import com.example.MovieBooking.models.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seats, Long> {

    @Query("SELECT s FROM Seats s WHERE s.seatNumber = :seatNumber AND s.show.id = :showId")
    Seats findBySeatNumberAndShowId(@Param("seatNumber") String seatNumber, @Param("showId") Long showId);

}
