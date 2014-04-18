package com.tw.smartpool.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CarPool {
    @Id
    @Column(name = "pool_id")
    private int poolId;
    @ManyToOne
    private Route route;
    @OneToOne
    private Car car;
    @Column(name = "user_list")
    @ElementCollection(targetClass = User.class)
    private List<User> userList;

    public CarPool() {
    }

    public CarPool(int poolId, Route route, Car car, List<User> users){
        this.poolId=poolId;
        this.route=route;
        this.car=car;
        this.userList = new ArrayList<>(users);
    }


    public void addUser(User user) {
        this.userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }
}
