package com.tw.smartpool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
public class Route {
    @Id
    private int id;
    @Column
    String[] points;

    public Route(int id,String[] points){
        this.id=id;
        this.points = points.clone();
    }

    public boolean hasPoint(String p) {
        for(String point: points) {
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
        if (!Arrays.equals(points, route.points)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (points != null ? Arrays.hashCode(points) : 0);
        return result;
    }
}
