package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Attendance;

public class AttendanceRowMapper implements RowMapper<Attendance> {

	@Override
	public Attendance mapRow(ResultSet rs, int rowNum) throws SQLException {
		Attendance attendance = new Attendance();
		attendance.setId(rs.getString("id"));
		attendance.setCompanyName(rs.getString("companyName"));
		attendance.setName(rs.getString("name"));
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

}
