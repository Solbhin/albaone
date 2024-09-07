package com.springmvc.repository;

import java.time.LocalDate;
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
		String SQL = "SELECT a.id, j.companyName, a.businessNumber, u.name, a.check_in_time, a.check_out_time, a.workHours "
				+ "FROM attendance a "
				+ "INNER JOIN user u ON a.id = u.id "
				+ "INNER JOIN jobPost j ON a.businessNumber = j.businessNumber "
				+ "WHERE a.id = ?";
		List<Attendance> listOfAttendance = template.query(SQL, new Object[] { id }, new AttendanceRowMapper());
		return listOfAttendance;
	}
	
	@Override
	public List<Attendance> getAttendancesByBusinessNumber(String businessNumber) {
		String SQL = "SELECT a.id, j.companyName, a.businessNumber, u.name, a.check_in_time, a.check_out_time "
				+ "FROM attendance a "
				+ "inner join user u on a.id = u.id "
				+ "INNER JOIN jobPost j ON a.businessNumber = j.businessNumber "
				+ "WHERE a.businessNumber = ?";
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

	@Override
	public int get3MonthWorkMinutes(String id, String businessNumber, LocalDate dateAll1, LocalDate dateAll2) {
		String SQL = "SELECT sum(workHours) AS workMinutes "
				+ "FROM attendance "
				+ "WHERE id = ? AND businessNumber = ? AND check_in_time >= ? AND check_out_time <= ?";
		return template.queryForObject(SQL, Integer.class, id, businessNumber, dateAll1, dateAll2);
	}

	
}
