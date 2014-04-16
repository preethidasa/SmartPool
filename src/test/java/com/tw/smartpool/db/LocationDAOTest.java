package com.tw.smartpool.db;

import com.tw.smartpool.model.Location;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationDAOTest {
    @Test
    public void shouldReturnPointWithGivenId() throws Exception{
        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.find(Location.class, 1)).thenReturn(new Location(1, "Test"));

        LocationDAO locationDAO = new LocationDAO(entityManager);

        assertEquals(new Location(1, "Test"), locationDAO.getById(1));
    }
}
