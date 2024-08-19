package com.springmvc.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Empolyee;

@Repository
public class empolyeeRepositoryImpl implements empolyeeRepository {
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Empolyee> getAllEmpolyee(String businessNumber) {
		String SQL = "SELECT empolyee.id, user.name "
				+ "FROM empolyee "
				+ "INNER JOIN user ON empolyee.id = user.id "
				+ "WHERE empolyee.businessNumber = ?";
		return template.query(SQL, new Object[] {businessNumber},(rs, rowNum) -> new Empolyee(rs.getString("id"), rs.getString("name")));
	}
	
	@Override
	public List<Empolyee> getMyCompany(String id) {
		String SQL = "SELECT businessNumber from empolyee where id = ?";
		return template.query(SQL, new Object[] {id},(rs, rowNum) -> new Empolyee(rs.getString("businessNumber")));
		
	}

	@Override
	public void addEmpolyee(String id, String businessNumber) {
		String SQL = "INSERT INTO empolyee VALUES(?, ?)";
		template.update(SQL, businessNumber, id);
	}

}
