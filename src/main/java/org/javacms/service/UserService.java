package org.javacms.service;

import org.javacms.beans.User;

public interface UserService {
	
	public boolean checkUserWithIdAndPassword(String userId, String password);
	
	public boolean changePassword(String newPassword, String userId, String oldPassword);
	
	public User getUserByUsername(String username);
}
