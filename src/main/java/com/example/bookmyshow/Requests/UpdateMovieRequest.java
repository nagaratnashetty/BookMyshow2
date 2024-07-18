package com.example.bookmyshow.Requests;

import com.example.bookmyshow.Enums.Language;

import lombok.Data;

@Data
public class UpdateMovieRequest {

    private String movieName;
    private Language newLanguage;
    private Double newRating;

}