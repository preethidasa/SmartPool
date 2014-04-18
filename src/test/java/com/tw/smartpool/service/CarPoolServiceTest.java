package com.tw.smartpool.service;

import com.tw.smartpool.db.CarPoolDAO;
import com.tw.smartpool.db.LocationDAO;
import com.tw.smartpool.model.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarPoolServiceTest {
    @Test
    public void shouldGetListOfCarPoolsByLocation(){
        CarPoolDAO carPoolDAO = mock(CarPoolDAO.class);
        LocationDAO locationDAO = mock(LocationDAO.class);
        CarPool pool = new CarPool(1,mock(Route.class),mock(Car.class),Arrays.asList(mock(User.class)));
        when(locationDAO.getById(1)).thenReturn(new Location(1,"Bellandhur"));
        when(carPoolDAO.getCarPoolsByLocation(new Location(1,"Bellandhur"))).thenReturn(Arrays.asList(pool));
        CarPoolService poolService = new CarPoolService(carPoolDAO,locationDAO);
        List<CarPool> carPools = poolService.getCarPoolsByLocation("1");
        assertNotNull(carPools);
    }
}
