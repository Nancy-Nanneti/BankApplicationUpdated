package com.bookapp.model.service;

import com.bookapp.model.entities.User;
import java.util.*;
public interface UserService {

	public User getUserById(int id);
	public List<User> getAllUser();
	public User updateUser(int id,User user);
	public User deleteUser(int id);
	public User getUser(String username, String password);
	public void addUser(User user);
	public boolean verifyDetails(String username, String password);

}
