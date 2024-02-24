package com.clone.bookmyshow.models;

import com.clone.bookmyshow.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated
    private ShowSeatStatus showSeatStatus;
//    Date bookedAt;
}