package com.tw.smartpool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Route {
    @Id
    private int id;
    @Column
    List<Location> dropPoints;

    public Route(int id, List<Location> dropPoints) {
        this.id = id;
        this.dropPoints = new ArrayList<Location>(dropPoints);
    }

    public boolean hasPoint(Location p) {
        for(Location point: dropPoints) {
            if( point.equals(p)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (id != route.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
