package com.tw.smartpool.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name= Point.LOAD_ALL_POINTS, query="from Point")

})
public class Point {

    public static final String LOAD_ALL_POINTS = "loadAllPoints";

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (id != point.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
