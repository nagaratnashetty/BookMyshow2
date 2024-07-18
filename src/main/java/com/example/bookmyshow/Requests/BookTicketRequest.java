package com.example.bookmyshow.Requests;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class BookTicketRequest {

    private List<String> requestedSeats;
    private Integer showId;
    private Integer userId;
}
