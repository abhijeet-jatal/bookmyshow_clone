package com.clone.bookmyshow.services;

import com.clone.bookmyshow.models.Show;
import com.clone.bookmyshow.models.ShowSeat;
import com.clone.bookmyshow.models.ShowSeatType;
import com.clone.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    @Autowired
    private ShowSeatTypeRepository showSeatTypeRepository;

    public int calculatePrice(List<ShowSeat> showSeatList, Show show){

        //1. Get all showSeatType for that shoe
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        //2. Get seatType of the showSeat
        int amount = 0 ;
        for(ShowSeat showSeat: showSeatList){
            for(ShowSeatType showSeatType: showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    //3. Add amount for all seats
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}