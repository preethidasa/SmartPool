package com.tw.smartpool.model;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RouteTest {
    @Test
    public  void shouldReturnTrueIfPointLiesInRoute() {
        Route r = new Route(1,2, new String[]{"Bellandur","ThoughtWorks"});
        assertTrue(r.hasPoint("Bellandur"));
    }

    @Test
    public void shouldEqualRoute() {
        Route r = new Route(1,2, new String[]{"Bellandur","ThoughtWorks"});
        assertTrue(r.equals(new Route(1, 2, new String[]{"Bellandur", "ThoughtWorks"})));
    }
}