package com.test.demo.service;

import javax.annotation.Resource;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.demo.dao.UserDao;
import com.test.demo.dao.impl.UserDaoImpl;
import com.test.demo.domain.User;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@PrepareForTest(UserDao.class)*/
//public class DemoServiceTester extends AbstractJUnit4SpringContextTests{
public class DemoServiceTester{
	/*@Resource
	private DemoService service;*/
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	//@PrepareForTest(UserDaoImpl.class)
	@Test
	public void testGetName() {
		DemoService service = new DemoService();
		
		UserDao mockDao = PowerMockito.mock(UserDaoImpl.class);
		User user = new User();
		user.setId(10);
		user.setName("mockName");
		user.setAddress("mockAddress");
		user.setMoney(2000);
		Mockito.when(mockDao.findUserById(10L)).thenReturn(user);
		
		String res = service.getName(10L);
		assertTrue("mockName".equals(res));
	}
	
	/*@Test
	@PrepareForTest(UserDao.class)
	public void testGetName() {
		//DemoService service = new DemoService();
		User user = new User();
		user.setId(10);
		user.setName("mockName");
		user.setAddress("mockAddress");
		user.setMoney(2000);
		UserDao mockDao = PowerMockito.spy(new UserDaoImpl(null));
		Mockito.when(mockDao.findUserById(10L)).thenReturn(user);
		User res = mockDao.findUserById(10);
		assertTrue("mockName".equals(res.getName()));
	}*/
	
}
