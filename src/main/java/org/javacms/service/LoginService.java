package org.javacms.service;

import javax.servlet.http.HttpSession;

import org.javacms.beans.User;

public interface LoginService {
    public Boolean login(String username, String password);
}
