package com.springmvc.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public void setNewUser(User user) {
		String SQL = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?)";
		template.update(SQL, user.getId(), user.getPassword(), user.getName(), user.getPhone(), user.getEmail(), user.getBusinessNumber());
	}

	@Override
	public boolean loginUser(String id, String password) {
		String SQL = "SELECT COUNT(*) FROM user WHERE id = ? AND password = ?";
		Integer count = template.queryForObject(SQL, new Object[] {id, password}, Integer.class);
		return (count!=null && count > 0);
	}

	@Override
	public String findBusinessNumber(String id) {
		String SQL = "SELECT businessNumber FROM user WHERE id = ?";
		return template.queryForObject(SQL, new Object[] {id}, String.class);
	}
		
	@Override
	public void updateUser(User user) {
		String SQL = "UPDATE user SET ";
		
	}
	
	@Override
	public User finUserById(String id) {
		String SQL = "SELECT * FROM user WHERE id = ?";
		return template.queryForObject(SQL, new Object[] {id}, (rs, rowNum)->{
			User user = new User();
			user.setId(rs.getString("id"));
			//user.setPassword(rs.getString("password"));
			user.setPassword(rs.getString("pw"));
			user.setName(rs.getString("name"));
			user.setPhone(rs.getString("phone"));
			user.setEmail(rs.getString("email"));
			user.setBusinessNumber(rs.getString("businessNumber"));
			return user;
		});
	}

	
}
