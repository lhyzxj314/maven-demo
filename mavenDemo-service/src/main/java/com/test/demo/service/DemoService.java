package com.test.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.demo.dao.impl.UserDaoImpl;
import com.test.demo.domain.User;

@Service
public class DemoService {
  
  @Resource
  private UserDaoImpl dao;
  
  public String getName(Long id) {
    if (id == null)
      return null;
    String welcom = "肖俊";
    if (id != null && id != 1) 
      return "请输入id=1";
    else
      return "欢迎你," + welcom;
  }
  
  public void addUser(User user) {
	  if (user == null)  return;
	  dao.insert(user);
  }
}
