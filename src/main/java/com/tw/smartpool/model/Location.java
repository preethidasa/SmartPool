package com.tw.smartpool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    private int id;

    @Column
    private String name;

    public Location() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        return id == ((Location)o).id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
