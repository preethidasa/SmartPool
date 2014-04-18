package com.tw.smartpool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @Column(length = 10)
    private String registrationNumber;
    @Column
    private int capacity;

    public Car() {
    }

    public Car(String registrationNumber, int capacity) {
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
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