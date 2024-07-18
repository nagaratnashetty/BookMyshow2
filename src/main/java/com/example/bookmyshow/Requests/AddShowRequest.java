package com.example.bookmyshow.Requests;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddShowRequest {

    private LocalDate showDate;
    private LocalTime showTime;

    private String movieName;
    private Integer theaterId;

}