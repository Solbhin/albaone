package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Attendance;

@Repository
public class QRcodeRepositoryImpl implements QRcodeRepository {
	private JdbcTemplate template;

	@Autowired
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public void checkIn(String id, String datetime, String businessNumber) {
		String SQL = "INSERT INTO attendance (id, check_in_time, businessNumber) VALUES(?, ?, ?)";
		template.update(SQL, id, datetime, businessNumber);
	}

	@Override
	public Attendance getLastAttendance(String id) {
		String SQL = "SELECT * "
				+ "FROM attendance "
				+ "WHERE id = ? "
				+ "ORDER BY check_in_time DESC LIMIT 1";
		try {
			return template.queryForObject(SQL, new Object[] { id }, this::mapRowToAttendance);
		} catch (Exception e) {
			return null;
		}
	}

	private Attendance mapRowToAttendance(ResultSet rs, int rowNum) throws SQLException {
		Attendance attendance = new Attendance();
		attendance.setId(rs.getString("id"));
		String checkInTimeString = rs.getString("check_in_time");
	    if (checkInTimeString != null) {
	        attendance.setCheckInTime(LocalDateTime.parse(checkInTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	    }
	    String checkOutTimeString = rs.getString("check_out_time");
	    if (checkOutTimeString != null) {
	        attendance.setCheckOutTime(LocalDateTime.parse(checkOutTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	    } else {
	        attendance.setCheckOutTime(null);
	    }
		return attendance;
	}

	@Override
	public void checkOut(String id, String time, long flooredMinutes) {
		String SQL = "UPDATE attendance SET check_out_time = ?, workHours = ? WHERE id = ? AND check_out_time IS NULL";
		template.update(SQL, time, flooredMinutes ,id);
	}

}
