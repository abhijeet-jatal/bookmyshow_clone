package com.clone.bookmyshow.models;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import java.util.List;

@Data
public class Theater extends BaseModel{
    private String name;
    @ManyToOne
    private Region region;
    @ManyToOne
    private List<Screen> screens;
}
