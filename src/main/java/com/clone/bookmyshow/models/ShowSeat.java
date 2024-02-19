package com.clone.bookmyshow.models;

import com.clone.bookmyshow.enums.ShowSeatStatus;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated
    private ShowSeatStatus showSeatStatus;
}
