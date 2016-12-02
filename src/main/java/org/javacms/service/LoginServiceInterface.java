package org.javacms.service;

import org.javacms.beans.User;

public interface LoginServiceInterface {
    public User login(String username, String password);
}
