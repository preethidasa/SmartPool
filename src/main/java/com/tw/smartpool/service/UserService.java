package com.tw.smartpool.service;

import com.tw.smartpool.db.UserDAO;
import com.tw.smartpool.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO dao;

    public UserService() {
    }

    public UserService(UserDAO dao) {
        this.dao = dao;
    }

    @Transactional
    public List<User> getUserListByName(String name){
        return dao.getUserByName(name);
    }
}
