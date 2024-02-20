package com.clone.bookmyshow.services;

import com.clone.bookmyshow.dtos.BookMovieRequestDTO;
import com.clone.bookmyshow.models.Booking;

import java.util.List;

public class BookingService {
//    public Booking bookTicket(BookMovieRequestDTO bookMovieRequestDTO)

    public Booking bookTicket(Long userId, Long showId, List<String> showSeatIds){
        //Start Transaction
        //1. Get the user with userId
        //2. Get the show with the showId
        //3. Get all show seats with showSeatIds
        //4. Check if ALL show Seats are available
        //5. If NOT, throw an arr
        //6. If yes, mark the status of show Seats as LOCKED
        //7. Persist updated statuses in DB
        //8. Create a Booking object and save in DB
        //9. Create and return object BookMovieResponseDTO
        //End Transaction


        return null;
    }
}