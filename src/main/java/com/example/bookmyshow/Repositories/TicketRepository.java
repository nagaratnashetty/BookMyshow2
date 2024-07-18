package com.example.bookmyshow.Repositories;

import com.example.bookmyshow.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {
}