package com.example.bookmyshow.Repositories;

import com.example.bookmyshow.Models.TheaterSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatsRepository extends JpaRepository<TheaterSeat,Integer> {
}