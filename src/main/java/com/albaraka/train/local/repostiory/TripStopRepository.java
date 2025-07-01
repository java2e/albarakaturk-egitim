package com.albaraka.train.local.repostiory;

import com.albaraka.train.local.entity.TripStop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripStopRepository extends JpaRepository<TripStop, Long> {
    List<TripStop> findByTripTripIdOrderByStopSequence(Long tripId);
}