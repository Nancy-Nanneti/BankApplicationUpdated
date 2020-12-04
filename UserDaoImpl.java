package com.bookapp.model.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookapp.model.dao.UserDao;
import com.bookapp.model.dao.Exceptions.UserNotFoundException;
import com.bookapp.model.entities.User;

public class UserDaoImpl implements UserDao{
	
	private SessionFactory factory;

	@Autowired
	public UserDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

		private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public User getUser(String username, String password) {
		Query query = getSession().createQuery("from User where username=:username1 and password=:password1");
		query.setParameter("username1", username);
		query.setParameter("password1", password);
		User user = (User) query.getSingleResult();
		return user;
	}

	@Override
	public User addUser(User user) {
		getSession().save(user);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return getSession().createQuery("from User").list();
	}

	@Override
	public User getUserById(int id) {

		User user = getSession().get(User.class, id);

		if (user != null)
			return user;
		else
			throw new UserNotFoundException("user with id:" + id + " is not found");
	}

	@Override
	public User deleteUser(int id) {
		User user = getUserById(id);
		getSession().delete(user);
		return user;
	}

	@Override
	public User updateUser(int id, User user) {
		User userToUpdate = getUserById(id);
		userToUpdate.setAddress(user.getAddress());
		userToUpdate.setPhoneno(user.getPhoneno());
		userToUpdate.setEmail(user.getEmail());
		getSession().update(userToUpdate);
		return userToUpdate;
	}


}
