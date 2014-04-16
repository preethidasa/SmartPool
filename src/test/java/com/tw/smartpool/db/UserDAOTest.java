package com.tw.smartpool.db;

import com.tw.smartpool.model.Location;
import com.tw.smartpool.model.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class UserDAOTest {
    private UserDAO userDAO;
    private Query query;
    private EntityManager entityManager;
    @Before
    public void setUp(){
        entityManager = mock(EntityManager.class);
        query = mock(Query.class);
        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.setParameter("name", "%manu%")).thenReturn(query);
        userDAO = new UserDAO(entityManager);
    }

    @Test
    public void shouldReturnUserList() throws Exception {
        List<User> users= new ArrayList<User>(1);
        users.add(new User("12345","manu","viswam",new Location(1,"Test")));
        when(query.getResultList()).thenReturn(users);
        List<User> userList = userDAO.getUserByName("manu");
        for(User user : userList){
            Assert.assertTrue(user.getFirstName().contains("manu")||user.getLastName().contains("manu"));
        }
    }

    @Test
    public void shouldCallMethodsOfEntityManager() throws Exception {
        userDAO.addUser(new User("12345","manu","viswam",new Location(1,"Test")));
        verify(entityManager,times(1)).persist(anyObject());
        verify(entityManager,times(1)).flush();
    }

    @Test
    public void shouldReturnNull(){
        when(query.getResultList()).thenReturn(new ArrayList());
        List<User> userList = userDAO.getUserByName("manu");
        assertNull(userList);
    }
}
