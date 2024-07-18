package com.example.bookmyshow.Controllers;


import com.example.bookmyshow.Models.Theater;
import com.example.bookmyshow.Requests.AddTheaterRequest;
import com.example.bookmyshow.Requests.AddTheaterSeatsRequest;
import com.example.bookmyshow.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("add")
    public ResponseEntity addTheater(@RequestBody AddTheaterRequest theaterRequest){

        String response = theaterService.addTheater(theaterRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }


    @PutMapping("associateSeats")
    public ResponseEntity associateSeats(@RequestBody AddTheaterSeatsRequest theaterSeatsRequest){

        String response = theaterService.associateTheaterSeats(theaterSeatsRequest);
        return new ResponseEntity(response,HttpStatus.OK);
    }


}