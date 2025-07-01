package com.albaraka.train.local.repostiory;

import com.albaraka.train.local.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Optional<Trip> findByTripNumber(String tripNumber);
}