package com.clone.bookmyshow.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookMovieRequestDTO {
    private List<Long> showSeatIds;
    private Long showId;
    private Long userId;

}