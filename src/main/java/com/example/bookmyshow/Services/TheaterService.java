package com.example.bookmyshow.Services;

import com.example.bookmyshow.Enums.SeatType;
import com.example.bookmyshow.Models.Theater;
import com.example.bookmyshow.Models.TheaterSeat;
import com.example.bookmyshow.Repositories.TheaterRepository;
import com.example.bookmyshow.Repositories.TheaterSeatsRepository;
import com.example.bookmyshow.Requests.AddTheaterRequest;
import com.example.bookmyshow.Requests.AddTheaterSeatsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatsRepository theaterSeatsRepository;

    public String addTheater(AddTheaterRequest theaterRequest){

        Theater theater = Theater.builder().noOfScreens(theaterRequest.getNoOfScreens())
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .build();

        theater = theaterRepository.save(theater);
        return "Theater has been saved to the DB with theaterId "+theater.getTheaterId();
    }

    public String associateTheaterSeats(AddTheaterSeatsRequest theaterSeatsRequest) {

        int theaterId = theaterSeatsRequest.getTheaterId();
        int noOfClassicSeats = theaterSeatsRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = theaterSeatsRequest.getNoOfPremiumSeats();

        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        //1. Get the theaterEntity from DB
        Theater theater = theaterRepository.findById(theaterId).get();

        //2. Generate those seatNos through for Classic Seats

        int noOfRowsOfClassicSeats = noOfClassicSeats/5; //Complete rows that i can build
        int noOfSeatsInLastRowClassic = noOfClassicSeats%5;
        int row;
        for(row= 1; row<=noOfRowsOfClassicSeats; row++) {

            for(int j=1;j<=5;j++) {

                char ch = (char)('A'+j-1);
                String seatNo = "" + row + ch;

                TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo)
                        .seatType(SeatType.CLASSIC)
                        .theater(theater)
                        .build();
                theaterSeatList.add(theaterSeat);
            }
        }

        //For the last row
        for(int j=1;j<=noOfSeatsInLastRowClassic;j++) {
            char ch = (char)('A'+j-1);
            String seatNo = "" + row + ch;
            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeat);
        }

        //Same logic for the premium seats
        int noOfRowsInPremiumSeats = noOfPremiumSeats/5;
        int noOfSeatsInLastRowPremium = noOfPremiumSeats%5;

        int currentRow = row;
        if(noOfSeatsInLastRowClassic>0){
            currentRow++;
        }
        for(row=currentRow;row<=noOfRowsInPremiumSeats+currentRow-1; row++) {
            for(int j=1;j<=5;j++) {
                char ch = (char)('A'+j-1);
                String seatNo = "" + row + ch;
                TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo)
                        .seatType(SeatType.PREMIUM)
                        .theater(theater)
                        .build();
                theaterSeatList.add(theaterSeat);
            }
        }
        //For the last row
        for(int j=1;j<=noOfSeatsInLastRowPremium;j++){
            char ch = (char)('A'+j-1);
            String seatNo = "" + row + ch;
            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeat);
        }

        theater.setTheaterSeatList(theaterSeatList);
        theaterRepository.save(theater);

        //Save all the generated Theater seats into the DB
        theaterSeatsRepository.saveAll(theaterSeatList);
        return "The theater seats have been associated";
    }
}