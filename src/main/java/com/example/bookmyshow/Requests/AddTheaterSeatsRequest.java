package com.example.bookmyshow.Requests;

import lombok.Data;

@Data
public class AddTheaterSeatsRequest { //DTO are custom classes helping
    // you take input from clients

    private Integer theaterId;
    private Integer noOfClassicSeats;
    private Integer noOfPremiumSeats;
}