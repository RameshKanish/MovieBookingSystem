package com.example.MovieBooking.repository;

import com.example.MovieBooking.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByEmail(String email);

    @Query(value = "SELECT * FROM users u WHERE u.email = :email AND u.password = :password", nativeQuery = true)
    Optional<Users> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}