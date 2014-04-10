package com.tw.smartpool.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CarPoolTest {
   @Test
    public void shouldReturnListOfAllCarsGoingThroughPoint() {
       Car[] c = new Car[3];
       Route r = new Route(1,2, new String[]{"Bellandur","ThoughtWorks"});
       c[0] = new Car("KA 01 4567",6,r);
       r = new Route(1,2, new String[]{"Btm","ThoughtWorks"});
       c[1] = new Car("KA 01 4568",6,r);
       r = new Route(1,2, new String[]{"Marathalli","Itpl"});
       c[2] = new Car("KA 01 4569",6,r);
       CarPool cp = new CarPool(3,c);
       Car[] result = cp.carsPassingThroughPoint("ThoughtWorks");
       assertTrue( c[0].equals(result[0]) );
       assertTrue( c[1].equals(result[1]) );
       assertEquals( null, result[2] );
   }
}
