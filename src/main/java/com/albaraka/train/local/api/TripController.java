package com.albaraka.train.local.api;


import com.albaraka.train.core.service.BaseController;
import com.albaraka.train.core.service.BaseService;
import com.albaraka.train.local.entity.Trip;
import com.albaraka.train.local.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
public class TripController extends BaseController<Trip> {


    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @Override
    public BaseService getBaseService() {
        return tripService;
    }


}
