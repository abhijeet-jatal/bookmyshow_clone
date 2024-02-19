package com.clone.bookmyshow.models;

import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private  SeatType seatType;
    private int price;
}
