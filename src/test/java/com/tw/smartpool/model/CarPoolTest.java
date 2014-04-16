package com.tw.smartpool.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class CarPoolTest {

    @Test

    public void shouldAddUserToCarPool() {
        User user = new User("123", "manu", "sunnyp", "cochin");
        List<User> newList = new ArrayList<User>();
        CarPool carPool = new CarPool( 12, mock(Route.class), mock(Car.class), newList);
        carPool.addUser(user);
        Assert.assertEquals(user, carPool.getUserList().get(0));

    }


}

