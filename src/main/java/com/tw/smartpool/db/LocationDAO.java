package com.tw.smartpool.db;

import com.tw.smartpool.model.Location;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LocationDAO {
    @PersistenceContext
    EntityManager entityManager;

    public LocationDAO() {
    }

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Location getById(int id){
        return entityManager.find(Location.class, id);
    }
}
