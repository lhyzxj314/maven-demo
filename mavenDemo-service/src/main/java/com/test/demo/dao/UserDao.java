package com.test.demo.dao;

import com.test.demo.domain.User;

public interface UserDao {
	public void insertUser(User user);
	public User findUserById(long id);
	public void updateUser(User user);
}
