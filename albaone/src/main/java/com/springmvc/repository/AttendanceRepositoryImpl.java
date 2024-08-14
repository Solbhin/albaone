package com.springmvc.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Attendance;

@Repository
public class AttendanceRepositoryImpl implements AttendanceRepository
{

	private JdbcTemplate template;

	@Autowired
	public void setJdbctemplate(DataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Attendance> getAllAttendances(String id) {
		String SQL = "SELECT * FROM attendance WHERE id = ?";
		List<Attendance> listOfAttendance = template.query(SQL, new Object[] { id }, new AttendanceRowMapper());
		return listOfAttendance;
	}
	
	@Override
	public List<Attendance> getAttendancesByBusinessNumber(String businessNumber) {
		String SQL = "SELECT * FROM attendance WHERE businessNumber = ?";
		List<Attendance> listOfAttendance = template.query(SQL, new Object[] {businessNumber}, new AttendanceRowMapper());
		return listOfAttendance;
	}
	
	@Override
	public void deleteAttendance(String id) {
		String SQL = "DELETE FROM attendance WHERE id = ?";
		template.update(SQL, id);
	}

	@Override
	public void addAttendance(Attendance attendance) {
		String SQL = "INSERT INTO attendance(id, check_in_time, check_out_time) VALUES(?, ?, ?)";
		template.update(SQL, attendance.getId(), attendance.getCheckInTime(), attendance.getCheckOutTime());
	}
	
}
