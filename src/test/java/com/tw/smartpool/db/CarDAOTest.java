package com.tw.smartpool.db;

import com.tw.smartpool.model.Car;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class CarDAOTest {
    private EntityManager entitymanager;
    @Test
    public void shouldAddCar(){
        entitymanager=mock(EntityManager.class);
        CarDAO carDAO = new CarDAO(entitymanager);
        Car car =new Car("1234",5);
        carDAO.addCar(car);
        verify(entitymanager,times(1)).persist(anyObject());
        verify(entitymanager,times(1)).flush();
    }
    @Test
    public void shouldReturnCarbyId(){
        entitymanager=mock(EntityManager.class);
        CarDAO carDAO = new CarDAO(entitymanager);
        Car car =new Car("1234",5);
        when(entitymanager.find(anyObject(),"1234")).thenReturn(car);
        Assert.assertEquals(car,carDAO.getCarById("1234"));
    }
}
