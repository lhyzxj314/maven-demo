package com.test.demo.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.test.demo.dao.UserDao;
import com.test.demo.domain.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	//private DataSource dataSource;
	//private JdbcTemplate jdbcTemplate;

	public void insert(User user) {
		//jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "INSERT INTO USER VALUES (?,?,?)";
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		jdbcTemplate.update(sql, 
				user.getId(), user.getName(), user.getAddress());
	}

	public User findById(int id) {
		return null;
	}


	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	
}
