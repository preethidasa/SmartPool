package com.tw.smartpool.db;

import com.tw.smartpool.model.Car;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CarDAO {

    @PersistenceContext
    EntityManager entityManager;

    public CarDAO() {
    }

    public CarDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public boolean addCar(Car car){
        entityManager.persist(car);
        entityManager.flush();
        return true;
    }

    public Car getCarById(String id){
        return entityManager.find(Car.class,id);
    }
}
