package com.tw.smartpool.model;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class RouteTest {
    @Test
    public  void shouldReturnTrueIfPointLiesInRoute() {
        Route r =new Route(1, Arrays.asList(new Location(1,"Bellandhur")));
        assertTrue(r.hasPoint(new Location(1,"Bellandhur")));
    }

    @Test
    public void shouldEqualRoute() {
        Route r = new Route(1, Arrays.asList(new Location(1,"Bellandhur")));
        assertTrue(r.equals(new Route(1, Arrays.asList(new Location(1,"Bellandhur")))));
    }
}