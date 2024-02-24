package com.clone.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "theaters")
public class Theater extends BaseModel{
    private String name;
    @ManyToOne
    private Region region;
    @OneToMany
    private List<Screen> screens;
}