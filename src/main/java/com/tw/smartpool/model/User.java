package com.tw.smartpool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {
    @Id
    @Column(name = "emp_id",length = 10)
    private String empId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne
    private Location location;

    private User() {
    }

    public User(String empId, String firstName, String lastName, Location location) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    public String getEmpId() {
        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        return empId.equals( ((User)o).empId );
    }

    @Override
    public int hashCode() {
        return empId.hashCode();
    }
}
