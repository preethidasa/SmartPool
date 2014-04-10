package com.tw.smartpool.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CarTest {
    @Test
    public void shouldReturnTrueIfPointIsOnCarRoute() {
        Route r = new Route(1,2, new String[]{"Bellandur","ThoughtWorks"});
        Car c = new Car("KA 01 4567",6,r);
        assertTrue(c.hasPointOnRoute("Bellandur"));
    }
}
