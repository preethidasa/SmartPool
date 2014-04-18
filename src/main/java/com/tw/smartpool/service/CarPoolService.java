package com.tw.smartpool.service;

import com.tw.smartpool.db.CarPoolDAO;
import com.tw.smartpool.db.LocationDAO;
import com.tw.smartpool.model.CarPool;
import com.tw.smartpool.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPoolService {
    @Autowired
    CarPoolDAO carPoolDAO;

    @Autowired
    LocationDAO locationDAO;

    public CarPoolService() {
    }

    public CarPoolService(CarPoolDAO carPoolDAO, LocationDAO locationDAO) {
        this.carPoolDAO = carPoolDAO;
        this.locationDAO = locationDAO;
    }

    public List<CarPool> getCarPoolsByLocation(String locationId){
        Location location = locationDAO.getById(Integer.parseInt(locationId));
        if(location==null)
            return null;
        return carPoolDAO.getCarPoolsByLocation(location);
    }

    public void addCarPool() {
        carPoolDAO.addPool();
    }
}
