package com.clone.bookmyshow.models;

import jakarta.persistence.ManyToMany;
import lombok.Data;
import java.util.List;


@Data
public class User extends BaseModel{
    private String name;
    private String email;
    private String phoneNumber;
    @ManyToMany
    private List<Booking> booking;
}
