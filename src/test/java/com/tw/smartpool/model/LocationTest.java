package com.tw.smartpool.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationTest {
    @Test
    public void shouldReturnTrueIfPointsAreEqual() {
        Location location = new Location(5,"Bellandur");
        assertEquals(new Location(5,"Bellandur"), location);
    }
}
