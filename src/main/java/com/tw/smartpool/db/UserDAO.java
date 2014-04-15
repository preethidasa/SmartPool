package com.tw.smartpool.db;

import com.tw.smartpool.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDAO() {
    }

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getUserByName(String name){
        List<User> result= entityManager.createQuery("from User where first_name like :name or last_name like :name").setParameter("name","%"+name+"%").getResultList();
        return result.size() > 0 ? result : null ;
    }

    @Transactional
    public boolean addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
        return true;
    }
}
