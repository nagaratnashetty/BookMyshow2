package com.example.bookmyshow.Requests;

import lombok.Data;

@Data
public class AddTheaterRequest {

    private Integer noOfScreens;
    private String name;
    private String address;

}