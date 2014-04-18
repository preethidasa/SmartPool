package com.tw.smartpool.db;

import com.tw.smartpool.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
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
//        List<User> result= entityManager.createQuery("from User where first_name like :name or last_name like :name").setParameter("name","%"+name+"%").getResultList();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);
        ParameterExpression<String> pe =criteriaBuilder.parameter(String.class);

        Predicate p1 = criteriaBuilder.like(userRoot.get("firstName"), pe);
        Predicate p2 = criteriaBuilder.like(userRoot.get("lastName"),pe);
        query.select(userRoot).where(criteriaBuilder.or(p1,p2));

        TypedQuery<User> q = entityManager.createQuery(query);
        q.setParameter(pe,"%"+name+"%");
        List<User> result = q.getResultList();

        return result.size() > 0 ? result : null ;
    }

    @Transactional
    public boolean addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
        return true;
    }
}
