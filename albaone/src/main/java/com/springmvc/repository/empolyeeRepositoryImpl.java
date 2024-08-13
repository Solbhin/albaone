package com.springmvc.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Empolyee;

@Repository
public class empolyeeRepositoryImpl implements empolyeeRepository
{
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Empolyee> getAllEmpolyee(String businessNumber)
	{
		String SQL = "SELECT empolyee.id, user.name FROM empolyee INNER JOIN user ON empolyee.id = user.id WHERE empolyee.businessNumber = ?";
		return template.query(SQL, new Object[] {businessNumber},(rs, rowNum) -> new Empolyee(rs.getString("id"), rs.getString("name")));
	}

}
