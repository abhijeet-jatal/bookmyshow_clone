package com.clone.bookmyshow.controllerrs;

import com.clone.bookmyshow.dtos.BookMovieRequestDTO;
import com.clone.bookmyshow.dtos.BookMovieResponseDTO;
import com.clone.bookmyshow.enums.ResponseStatus;
import com.clone.bookmyshow.models.Booking;
import com.clone.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    public BookMovieResponseDTO bookTicket(BookMovieRequestDTO bookMovieRequestDTO) {
        BookMovieResponseDTO responseDTO = new BookMovieResponseDTO();
        try{
            Booking booking = bookingService.bookTicket(bookMovieRequestDTO.getUserId(), bookMovieRequestDTO.getShowId(), bookMovieRequestDTO.getShowSeatIds());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setBookingId(booking.getId());
        }
        catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}