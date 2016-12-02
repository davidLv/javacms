package org.javacms.service.impl;

import org.javacms.beans.User;
import org.javacms.dao.UserDao;
import org.javacms.service.LoginServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("loginService")
public class LoginServiceImpl implements LoginServiceInterface {
    @Autowired
    private UserDao userDao;
    public User login(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username, password);
    }

}
