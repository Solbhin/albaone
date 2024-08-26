package com.springmvc.repository;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployee(String businessNumber) {
		String SQL = "SELECT e.id, u.name, e.hireDate "
				+ "FROM employee e "
				+ "INNER JOIN user u "
				+ "ON e.id = u.id "
				+ "WHERE e.businessNumber = ?";
		return template.query(SQL, new Object[] {businessNumber},(rs, rowNum) -> new Employee(rs.getString("id"), rs.getString("name"), rs.getString("hireDate")));
	}
	
	@Override
	public List<Employee> getMyCompany(String id) {
		String SQL = "SELECT businessNumber from employee where id = ?";
		return template.query(SQL, new Object[] {id},(rs, rowNum) -> new Employee(rs.getString("businessNumber")));
		
	}

	@Override
	public void addEmployee(String employeeId, String businessNumber, LocalDate date) {
		String SQL = "INSERT INTO employee VALUES(?, ?, ?)";
		template.update(SQL, businessNumber, employeeId, date);
	}

	@Override
	public void resignationEmployee(String id, String businessNumber, LocalDate formattedDate) {
		String SQL = "UPDATE employee SET resignationDate = ? WHERE id = ? AND businessNumber = ?";
		template.update(SQL, formattedDate, id, businessNumber);
	}

}
