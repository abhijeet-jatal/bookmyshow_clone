package com.clone.bookmyshow.models;

import com.clone.bookmyshow.enums.Feature;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}