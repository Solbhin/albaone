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
				+ "WHERE e.businessNumber = ? AND e.resignationDate IS NULL";
		return template.query(SQL, new Object[] {businessNumber},(rs, rowNum) -> new Employee(rs.getString("id"), rs.getString("name"), rs.getString("hireDate")));
	}
	
	@Override
	public List<Employee> getMyCompany(String id) {
		String SQL = "SELECT businessNumber from employee where id = ?";
		return template.query(SQL, new Object[] {id},(rs, rowNum) -> new Employee(rs.getString("businessNumber")));
		
	}

	@Override
	public void addEmployee(String employeeId, String businessNumber, LocalDate date) {
		String SQL = "INSERT INTO employee(businessNumber, id, hireDate) VALUES(?, ?, ?)";
		template.update(SQL, businessNumber, employeeId, date);
	}

	@Override
	public void resignationEmployee(String id, String businessNumber, LocalDate formattedDate) {
		String SQL = "UPDATE employee SET resignationDate = ? WHERE id = ? AND businessNumber = ?";
		template.update(SQL, formattedDate, id, businessNumber);
	}

	@Override
	public List<Employee> getAllResignee(String businessNumber) {
		String SQL = "SELECT e.id, u.name, e.hireDate, e.resignationDate "
				+ "FROM employee e "
				+ "INNER JOIN user u "
				+ "ON e.id = u.id "
				+ "WHERE e.businessNumber = ? AND e.resignationDate IS NOT NULL";
		return template.query(SQL, new Object[] {businessNumber},(rs, rowNum) -> new Employee(rs.getString("id"), rs.getString("name"), rs.getString("hireDate"), rs.getString("resignationDate")));
	}
	
	@Override
	public Employee getOneResignee(String id, String businessNumber) {
		String SQL = "SELECT e.id, u.name, e.hireDate, e.resignationDate "
				+ "FROM employee e "
				+ "INNER JOIN user u "
				+ "ON e.id = u.id "
				+ "WHERE e.id = ? AND e.businessNumber = ?";
		return template.queryForObject(SQL, new Object[] {id, businessNumber},
				(rs, rowNum) -> new Employee(
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("hireDate"),
						rs.getString("resignationDate")));
	}
	
	@Override
	public List<Employee> getResignationHistory(String id) {
		String SQL = "SELECT e.id, u.name, e.hireDate, e.resignationDate, e.businessNumber "
				+ "FROM employee e "
				+ "INNER JOIN user u "
				+ "ON e.id = u.id "
				+ "WHERE e.id = ? AND resignationDate IS NOT NULL";
		List<Employee> employees = template.query(SQL, new Object[] {id}, (rs, rowNum) -> new Employee(rs.getString("id"), rs.getString("name"), rs.getString("hireDate"), rs.getString("resignationDate"), rs.getString("businessNumber")));
		
		return employees.isEmpty() ? null : employees;
	}

}
