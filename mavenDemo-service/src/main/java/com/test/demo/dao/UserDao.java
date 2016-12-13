package com.test.demo.dao;

import com.test.demo.domain.User;

public interface UserDao {
	public void insert(User user);
	public User findById(int id);
}
