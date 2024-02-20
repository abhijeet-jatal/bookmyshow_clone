package com.clone.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel{
    private  String seatNumber;
    private int rowVal;
    private int colVal;
    @ManyToMany
    private SeatType seatType;
}