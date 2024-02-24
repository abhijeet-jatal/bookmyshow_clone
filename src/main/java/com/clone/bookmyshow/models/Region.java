package com.clone.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import java.util.List;


@Data
@Entity
public class Region extends  BaseModel{
    private String name;
    @ManyToMany
    private List<Theater> theaters;
    @ManyToMany
    private List<Movie> movies;
}
