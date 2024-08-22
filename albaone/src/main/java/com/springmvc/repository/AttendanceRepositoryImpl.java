package com.springmvc.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Attendance;

@Repository
public class AttendanceRepositoryImpl implements AttendanceRepository {

	private JdbcTemplate template;

	@Autowired
	public void setJdbctemplate(DataSource dataSource) {
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
		String SQL = "SELECT a.id, a.businessNumber, a.companyName, u.name, a.check_in_time, a.check_out_time FROM attendance a inner join user u on a.id = u.id WHERE a.businessNumber = ?";
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
		String SQL = "INSERT INTO attendance(id, businessNumber, check_in_time, check_out_time, workHours) VALUES(?, ?, ?, ?, ?)";
		template.update(SQL, attendance.getId(), attendance.getBusinessNumber(), attendance.getCheckInTime(), attendance.getCheckOutTime(), attendance.getWorkHours());
	}
	
	@Override
	public void editAttendance(Attendance attendance, LocalDateTime checkInTime) {
		
		System.out.println(attendance.getCheckInTime());
		System.out.println(attendance.getCheckOutTime());
		System.out.println(attendance.getId());
		System.out.println(attendance.getBusinessNumber());
		System.out.println(checkInTime);
		
		String SQL = "UPDATE attendance SET check_in_time=?, check_out_time=?, workHours = ? WHERE id = ? AND businessNumber = ? AND check_in_time = ?";
		template.update(SQL, attendance.getCheckInTime(), attendance.getCheckOutTime(), attendance.getWorkHours(), attendance.getId(), attendance.getBusinessNumber(), checkInTime);
	}
	
}
