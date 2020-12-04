package com.bookapp.model.dao;

import java.util.*;

import com.bookapp.model.entities.User;

public interface UserDao {
	public List<User> getAllUser();
	public  User updateUser(int id,User user);
	public User getUserById(int id);
	public User deleteUser(int id);
	public  User addUser(User user);
	public  User getUser(String username, String password);

}
