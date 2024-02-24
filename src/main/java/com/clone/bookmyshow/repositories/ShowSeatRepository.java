package com.clone.bookmyshow.repositories;

import com.clone.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);

    // upsert - can act as update insert or update.
    @Override
    ShowSeat save(ShowSeat showSeat);
}