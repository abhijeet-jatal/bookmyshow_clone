package com.clone.bookmyshow.models;

import com.clone.bookmyshow.enums.Feature;
import com.clone.bookmyshow.enums.ShowStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> feature;
    private ShowStatus status;

}