package com.test.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.demo.dao.UserDao;
import com.test.demo.domain.User;

@Service
public class DemoService {

	@Resource
	private UserDao dao;

	public String getName(Long id) {
		if (id == null)
			return null;
		User user = dao.findUserById(id);
		return "欢迎你," + user.getName();
	}

	public void addUser(User user) {
		if (user == null)
			return;
		dao.insertUser(user);
	}

	@Transactional
	public void exchangeMoney(long userSrcId, long userDestId, double money) {
		User userSrc = dao.findUserById(userSrcId);
		User userDest = dao.findUserById(userDestId);
		userSrc.setMoney(userSrc.getMoney() - money);
		userDest.setMoney(userDest.getMoney() + money);
		dao.updateUser(userSrc);
		/* for test
		 * if (true) {
			throw new RuntimeException();
		}*/
		dao.updateUser(userDest);
	}
}
