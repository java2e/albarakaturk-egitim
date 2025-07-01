package com.albaraka.train.local.service;

import com.albaraka.train.core.service.BaseService;
import com.albaraka.train.local.entity.Station;
import com.albaraka.train.local.repostiory.StationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StationService extends BaseService<Station,Long> {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    protected JpaRepository<Station, Long> getRepository() {
        return stationRepository;
    }
}
