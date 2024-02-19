package com.clone.bookmyshow.models;

import com.clone.bookmyshow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Booking extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;
    @ManyToMany
    private List<ShowSeat> showSeat;
    @ManyToOne
    private User user;
    private Date bookedAt;
    @ManyToOne
    private Show show;
    private int amount;
    @OneToMany
    private List<Payment> payments;
}
