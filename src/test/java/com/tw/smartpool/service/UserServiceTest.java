package com.tw.smartpool.service;

import com.tw.smartpool.db.LocationDAO;
import com.tw.smartpool.db.UserDAO;
import com.tw.smartpool.model.Location;
import com.tw.smartpool.model.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Test
    public void shouldGetUserListWithGivenUser(){
        UserDAO dao = mock(UserDAO.class);
        LocationDAO locationDAO = mock(LocationDAO.class);

        User user = new User("12345","manu","viswam",new Location(1,"Test"));
        when(dao.getUserByName("man")).thenReturn(Arrays.asList(user));
        UserService userService =new UserService(dao, locationDAO);
        List<User> userList = userService.getUserListByName("man");
        assertEquals(user,userList.get(0));
    }

    @Test
    public void shouldReturnTrueIfDataIsPersisted() throws Exception {
        UserDAO dao = mock(UserDAO.class);
        LocationDAO locationDAO = mock(LocationDAO.class);
        User user = new User("12345","manu","viswam",new Location(1,"Test"));
        when(dao.addUser(user)).thenReturn(true);
        when(locationDAO.getById(1)).thenReturn(new Location(1,"Test"));
        UserService userService = new UserService(dao, locationDAO);
        assertTrue(userService.addUser("12345","manu","viswam","1"));
    }
}
