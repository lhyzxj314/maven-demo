package com.test.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
  public String getName(Long id) {
    if (id == null)
      return null;
    String welcom = "肖俊";
    if (id != null && id != 1) 
      return "请输入id=1";
    else
      return "欢迎你," + welcom;
  }
}
