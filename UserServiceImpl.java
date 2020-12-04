package com.bookapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.dao.UserDao;
import com.bookapp.model.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	
		private UserDao userDao;

		@Autowired
		public UserServiceImpl(UserDao userDao) {
			this.userDao = userDao;
		}

		@Override
		public User getUser(String username, String password) {
			return userDao.getUser(username, password);
		}

		@Override
		public void addUser(User user) {
			userDao.addUser(user);
		}

		@Override
		public boolean verifyDetails(String username, String password) {
			User user = userDao.getUser(username, password);
			if (user.getUname().equals(username) && user.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}

		}

		@Override
		public User getUserById(int id) {
			// TODO Auto-generated method stub
			return userDao.getUserById(id);
		}

		@Override
		public List<User> getAllUser() {

			return userDao.getAllUser();
		}

		@Override
		public User deleteUser(int id) {

			return userDao.deleteUser(id);
		}

		@Override
		public User updateUser(int id,User user) {
			
			return userDao.updateUser(id,user);
		}
}
