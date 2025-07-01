package com.albaraka.train.local.api;

import com.albaraka.train.core.service.BaseController;
import com.albaraka.train.core.service.BaseService;
import com.albaraka.train.local.entity.Station;
import com.albaraka.train.local.service.StationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/station")
public class StationController extends BaseController<Station> {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public BaseService getBaseService() {
        return stationService;
    }


    /*

    create
    delete
    findAll
    findById
    update
     */

}
