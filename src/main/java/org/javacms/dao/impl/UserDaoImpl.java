package org.javacms.dao.impl;

import org.javacms.beans.User;
import org.javacms.dao.UserDao;
import org.javacms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper um;
    public User findUserByUsernameAndPassword(String username, String password) {
        return um.getUserByUsernameAndPassword(username, password);
    }

}
