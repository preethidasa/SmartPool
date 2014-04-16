package com.tw.smartpool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {
    @Id
    private String registrationNumber;
    @Column
    private int capacity;
    @OneToOne
    private Route route;

    public Car(String registrationNumber, int capacity, Route r) {
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
        this.route = r;
    }

    public boolean hasPointOnRoute(String point) {
        return this.route.hasPoint(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!registrationNumber.equals(car.registrationNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return registrationNumber.hashCode();
    }
}