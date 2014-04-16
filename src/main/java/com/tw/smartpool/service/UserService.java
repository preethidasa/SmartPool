package com.tw.smartpool.service;

import com.tw.smartpool.db.LocationDAO;
import com.tw.smartpool.db.UserDAO;
import com.tw.smartpool.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    LocationDAO locationDAO;

    private UserService() {
    }

    public UserService(UserDAO userDAO, LocationDAO locationDAO) {
        this.userDAO = userDAO;
        this.locationDAO = locationDAO;
    }

    @Transactional
    public List<User> getUserListByName(String name){
        return userDAO.getUserByName(name);
    }

    public boolean addUser(String empId, String firstName, String lastName, String locationId) {
        if(null == empId || null == firstName || null == locationId || "".equals(empId) || "".equals(firstName) || "".equals(locationId))
            return false;

        return userDAO.addUser(new User(empId,firstName,lastName, locationDAO.getById(Integer.parseInt(locationId))));
    }
}
