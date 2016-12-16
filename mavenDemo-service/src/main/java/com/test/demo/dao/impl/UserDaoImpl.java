package com.test.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.test.demo.dao.UserDao;
import com.test.demo.domain.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDaoImpl(DataSource dataSource) {
		setDataSource(dataSource);
		jdbcTemplate = getJdbcTemplate();
	}
	
	public void insertUser(User user) {
		String sql = "INSERT INTO user VALUES (?,?,?,?)";
		final Object[] params = new Object[]{user.getId(), user.getName(), user.getAddress(), user.getMoney()};
		jdbcTemplate.update(sql, params);
	}
	
	public void updateUser(User user) {
		String sql = "UPDATE user SET money=? WHERE id=?";
		jdbcTemplate.update(sql, user.getMoney(), user.getId());
	}

	public User findUserById(long id) {
		String sql = "SELECT id,name,address,money FROM user WHERE id=?";
		final Object[] params = new Object[]{id};
		List<User> res = jdbcTemplate.query(sql, params, new UserRowMapper());
		return res.get(0);
	}
	
	private static class UserRowMapper implements RowMapper<User> {
		
	    public User mapRow(ResultSet rs, int index) throws SQLException {
	        User user = new User();
	        user.setId(rs.getInt("id"));
	        user.setName(rs.getString("name"));
	        user.setAddress(rs.getString("address"));
	        user.setMoney(rs.getDouble("money"));
	        return user;
	    }
	    
	}  
}
