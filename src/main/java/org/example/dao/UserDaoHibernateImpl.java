package org.example.dao;

import org.example.bean.User;
import org.example.util.Util;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao{

    private final SessionFactory sessionFactory = Util.getHibernateConnection();

    @Override
    public void createUserTable() {

    }

    @Override
    public void dropUserTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void clearUserTable() {

    }
}
