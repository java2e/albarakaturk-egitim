package com.albaraka.train.local.service;


import com.albaraka.train.core.service.BaseService;
import com.albaraka.train.local.entity.Trip;
import com.albaraka.train.local.repostiory.TripRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TripService extends BaseService<Trip,Long> {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    protected JpaRepository<Trip, Long> getRepository() {
        return tripRepository;
    }

    public void test() throws Exception {
        throw new Exception("HATA FIRLATILDI1");
    }
}
