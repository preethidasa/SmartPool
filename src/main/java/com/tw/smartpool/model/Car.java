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

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        if (this.registrationNumber != ((Car) obj).registrationNumber) return false;
        if (this.capacity != ((Car) obj).capacity) return false;
        return route.equals(((Car) obj).route);
    }
}