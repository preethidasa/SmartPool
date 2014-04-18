package com.tw.smartpool.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class CarTest {
    @Test
    public void shouldReturnTrueIfPointIsOnCarRoute() {
        Route r = new Route(1, Arrays.asList(new Location(1,"Bellandhur")));
        Car c = new Car("KA 01 4567",6);
        assertTrue(c.equals(new Car("KA 01 4567",6)));
    }
}
