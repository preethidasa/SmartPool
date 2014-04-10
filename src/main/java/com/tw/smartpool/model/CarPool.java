package com.tw.smartpool.model;

public class CarPool {
    int numberOfCars;
    Car[] cars;
    public CarPool(int numberOfCars, Car[] c) {
        this.numberOfCars = numberOfCars;
        this.cars = c;
        // check if this needs to assigned element wise
    }

    public Car[] carsPassingThroughPoint(String point) {
        Car[] result = new Car[this.numberOfCars];
        int totalCars=0;
        for(Car c : this.cars) {
            if (c.hasPointOnRoute(point))
              result[totalCars++] = c;
        }
        return result;
    }
}