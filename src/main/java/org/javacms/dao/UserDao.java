package org.javacms.dao;

import org.javacms.beans.User;

public interface UserDao {
    public User findUserByUsernameAndPassword(String username, String password);
}
