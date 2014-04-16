package com.tw.smartpool.model;

import java.util.ArrayList;
import java.util.List;


public class CarPool {
    private int poolId;
    private Route route;
    private Car car;
    private List<User> userList;
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
