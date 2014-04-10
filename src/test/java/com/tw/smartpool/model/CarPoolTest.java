package com.tw.smartpool.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CarPoolTest {
   @Test
    public void shouldReturnListOfAllCarsGoingThroughPoint() {
       Car[] c = new Car[3];
       String destination = "ThoughtWorks";
       Route r = createRoute("Bellandur", destination);
       c[0] = new Car("KA 01 4567",6,r);
       r = createRoute("Btm", destination);
       c[1] = new Car("KA 01 4568",6,r);
       r = createRoute("Marathalli", "Itpl");
       c[2] = new Car("KA 01 4569",6,r);

       CarPool cp = new CarPool(3,c);
       Car[] result = cp.carsPassingThroughPoint(destination);

       assertTrue( c[0].equals(result[0]) );
       assertTrue( c[1].equals(result[1]) );
       assertEquals( null, result[2] );
   }

    private Route createRoute(String point, String destination) {
        return new Route(1,2, new String[]{point, destination});
    }
}
