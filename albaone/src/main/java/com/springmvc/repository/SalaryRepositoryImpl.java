package com.springmvc.repository;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Salary;

@Repository
public class SalaryRepositoryImpl implements SalaryRepository{
	
	private JdbcTemplate template;

	@Autowired
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int getPersonalSalary(String id, LocalDate firstDayOfMonth, LocalDate lastDayOfMonth) {
		String SQL = "SELECT SUM(workHours) FROM attendance WHERE id = ? AND check_in_time >= ? AND check_out_time <= ?";
		Integer totalWorkHours = template.queryForObject(SQL, Integer.class, id, firstDayOfMonth, lastDayOfMonth);
		
		return (totalWorkHours !=null) ? totalWorkHours : 0;
	}
	
	@Override
	public List<Salary> getBusinessSalary(String businessNumber, LocalDate firstDayOfMonth, LocalDate lastDayOfMonth) {
		String SQL = "SELECT a.id, u.name, a.businessNumber, SUM(a.workHours) AS totalWorkHours "
				+ "FROM attendance a "
				+ "INNER JOIN user u "
				+ "ON a.id = u.id "
				+ "WHERE a.check_in_time >= ? AND a.check_out_time <= ? "
				+ "GROUP BY a.id, a.businessNumber "
				+ "HAVING a.businessNumber = ?";
		return template.query(SQL, new Object[] { firstDayOfMonth, lastDayOfMonth, businessNumber }, (rs, rowNum) -> new Salary(rs.getString("id"),rs.getString("name"), rs.getInt("totalWorkHours")));
	}

}
