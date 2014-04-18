package com.tw.smartpool.db;

import com.tw.smartpool.model.Car;
import com.tw.smartpool.model.Location;
import com.tw.smartpool.model.Route;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class CarDAOTest {
    private CarDAO;
    private EntityManager entitymanager;
    private Query;
    @Test
    public void shouldAddCar(){
        entitymanager=mock(EntityManager.class);
        CarDAO carDAO = new CarDAO(entitymanager);
        Car car =new Car("1234",5);
        CarDAO.addCar(car);
        verify(entitymanager,times(1)).persist(anyObject());
        verify(entitymanager,times(1)).flush();
    }
    @Test
    public void shouldReturnCarbyId(){
        entitymanager=mock(EntityManager.class);
        CarDAO carDAO = new CarDAO(entitymanager);
        Car car =new Car("1234",5);
        when(entitymanager.find(anyObject(),"1234")).thenReturn(car);
        Assert.assertEquals(car,CarDAO.getCarbyId("1234"));
    }
}
