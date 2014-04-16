package com.tw.smartpool.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void shouldReturnTrueIfUsersAreEqual() {
        User user = new User("E123","Manu","EV",new Location(5,"Bellandur"));
        assertEquals(new User("E123","Manu","EV",new Location(5,"Bellandur")),user);
    }
}
