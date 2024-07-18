package com.example.bookmyshow.Repositories;

import com.example.bookmyshow.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,Integer> {
}