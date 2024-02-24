package com.clone.bookmyshow.services;

import com.clone.bookmyshow.enums.BookingStatus;
import com.clone.bookmyshow.enums.ShowSeatStatus;
import com.clone.bookmyshow.models.Show;
import com.clone.bookmyshow.models.ShowSeat;
import com.clone.bookmyshow.repositories.BookingRepository;
import com.clone.bookmyshow.repositories.ShowRepository;
import com.clone.bookmyshow.repositories.ShowSeatRepository;
import com.clone.bookmyshow.repositories.UserRepository;
import com.clone.bookmyshow.models.Booking;
import com.clone.bookmyshow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final BookingRepository bookingRepository;
    private final PriceCalculatorService priceCalculatorService;

    @Autowired
    public BookingService(
            UserRepository userRepository,
            ShowRepository showRepository,
            ShowSeatRepository showSeatRepository,
            BookingRepository bookingRepository,
            PriceCalculatorService priceCalculatorService
    )
    {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculatorService = priceCalculatorService;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long userId, Long showId, List<Long> showSeatIds){

        //Start Transaction
        //1. Get the user with userId
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty())
            throw new RuntimeException("user NOT Found");
        User bookedBy = userOptional.get();

        //2. Get the show with the showId
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty())
            throw new RuntimeException("show NOT Found");
        Show bookedShow = showOptional.get();

        // -- START TRANSACTION
        //3. Get all show seats with showSeatIds
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        // TODO :: That all showSeatIds may not be valid - Add Validations

        //4. Check if ALL show Seats are available
        for(ShowSeat showSeat : showSeats){
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.EMPTY))
                //5. If NOT, throw an arr
                throw new RuntimeException("Not all selected seats are available");
        }

        //6. If yes, mark the status of show Seats as LOCKED
        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            //7. Persist updated statuses in DB
            showSeatRepository.save(showSeat);
        }

        // -- END TRANSACTION
        //8. Create a Booking object and save in DB
        Booking booking = new Booking();
        booking.setStatus(BookingStatus.PENDING);
        booking.setShowSeat(showSeats);
        booking.setUser(bookedBy);
        booking.setShow(bookedShow);
        booking.setBookedAt(new Date());
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats, bookedShow));
        booking.setPayments(new ArrayList<>());

        return bookingRepository.save(booking);

        //9. Create and return object BookMovieResponseDTO
        //End Transaction

    }
}