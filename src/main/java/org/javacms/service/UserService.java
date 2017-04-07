package org.javacms.service;

import java.util.List;

import org.javacms.beans.User;

public interface UserService {
	
	boolean checkUserWithIdAndPassword(String userId, String password);
	
	boolean changePassword(String newPassword, String userId, String oldPassword);
	
	User getUserByUsername(String username);
	
	List<User> getUserList();
}
