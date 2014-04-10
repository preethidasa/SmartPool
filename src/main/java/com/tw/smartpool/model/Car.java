package com.tw.smartpool.model;

public class Car {
    private String number;
    private int numberOfSeats;
    private Route route;
    public Car(String number, int numberOfSeats, Route r) {
        this.number = number;
        this.numberOfSeats = numberOfSeats;
        this.route = r;
    }

    public boolean hasPointOnRoute(String point) {
        return this.route.hasPoint(point);
    }

    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(this.getClass() != obj.getClass() ) return false;
        if( this.number != ((Car)obj).number ) return false;
        if( this.numberOfSeats != ((Car)obj).numberOfSeats ) return false;
        return route.equals(((Car)obj).route);
    }
}
