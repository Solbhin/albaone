package com.springmvc.repository;

import java.time.LocalDate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Severance;

@Repository
public class SeveranceRepositoryImpl implements SeveranceRepository {
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void createSeverance(String id, String businessNumber, LocalDate hireDate, LocalDate formattedDate, long periodAll, String total,
			String average, String severance) {
		String SQL = "INSERT INTO severance VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(SQL, id, businessNumber, hireDate, formattedDate, periodAll, total, average, severance);
	}

	@Override
	public Severance getSeverance(String id, String businessNumber) {
		String SQL = "SELECT s.id, u.name, s.businessNumber, s.hireDate, s.resignationDate, s.period, s.total3MonthSalary, s.averageWage, s.severance "
				+ "FROM severance s "
				+ "INNER JOIN user u "
				+ "ON s.id = u.id "
				+ "WHERE s.id = ? AND s.businessNumber = ?";
		return template.queryForObject(SQL, new Object[] {id, businessNumber},
				(rs, rowNum) -> new Severance(
						rs.getString("name"),
						rs.getString("total3MonthSalary"),
						rs.getString("averageWage"),
						rs.getString("severance")));
	}

}
