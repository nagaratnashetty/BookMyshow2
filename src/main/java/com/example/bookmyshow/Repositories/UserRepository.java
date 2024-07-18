package com.example.bookmyshow.Repositories;

import com.example.bookmyshow.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}