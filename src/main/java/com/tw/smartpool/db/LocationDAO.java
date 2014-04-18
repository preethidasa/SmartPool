package com.tw.smartpool.db;

import com.tw.smartpool.model.Location;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public boolean addLocation(Location location){
        entityManager.persist(location);
        entityManager.flush();
        return true;
    }

    public Location getById(int id){
        return entityManager.find(Location.class, id);
    }
}
