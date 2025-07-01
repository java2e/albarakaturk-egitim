package com.albaraka.train.local.repostiory;

import com.albaraka.train.local.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}