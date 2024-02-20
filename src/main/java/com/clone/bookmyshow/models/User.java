package com.clone.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List;


@Data
@Entity(name = "users")
public class User extends BaseModel{
    private String name;
    private String email;
    private String phoneNumber;
    @OneToMany
    private List<Booking> booking;
}