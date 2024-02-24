package com.clone.bookmyshow.dtos;

import com.clone.bookmyshow.enums.ResponseStatus;
import lombok.Data;

@Data
public class BookMovieResponseDTO {
    private int amount;
    private Long bookingId;
    private ResponseStatus responseStatus;
}