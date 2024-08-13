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
import com.springmvc.domain.QRCode;

@Repository
public class QRcodeRepositoryImpl implements QRcodeRepository {
	private JdbcTemplate template;

	@Autowired
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

//	// QR 생성
//	@Override
//	public void create(QRCode qrdto) {
//		System.out.println("QR 코드 create 메서드 실행");
//
//		String sql = "insert into QRtable values (?,?,?)";
//
//		template.update(sql, qrdto.getId(), qrdto.getTodaytime(), qrdto.getTime());
//		return;
//	}

//	@SuppressWarnings("deprecation")
//	@Override
//	public QRCode read(String id) {
//		String sql = "SELECT id,today,todayintime FROM QRtable WHERE id = ?";
//
//		return template.queryForObject(sql, new Object[] { id }, (rs, rowNum) -> {
//			QRCode qrDto = new QRCode();
//			qrDto.setId(rs.getString("id"));
//			qrDto.setTodaytime(rs.getString("today"));
//			qrDto.setTime(rs.getString("todayintime"));
//
//			return qrDto;
//		});
//	}

//	@Override
//	public void update(QRCode qrdto) {
//		String sql = "update QRtable set todayintime = ?, todayquittime = ? where id = ? and today = ?";
//		template.update(sql, qrdto.getTime(), qrdto.getTime(), qrdto.getId(), qrdto.getTodaytime());
//	}

	@Override
	public void checkIn(String id, String datetime) {
		String SQL = "INSERT INTO attendance (id, check_in_time) VALUES(?, ?)";
		template.update(SQL, id, datetime);
	}

	@Override
	public Attendance getLastAttendance(String id) {
		String SQL = "SELECT * FROM attendance WHERE id = ? ORDER BY check_in_time DESC LIMIT 1";
		try {
			return template.queryForObject(SQL, new Object[] { id }, this::mapRowToAttendance);
		} catch (Exception e) {
			return null;
		}
	}

	private Attendance mapRowToAttendance(ResultSet rs, int rowNum) throws SQLException {
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

	@Override
	public void checkOut(String id, String time) {
		String SQL = "UPDATE attendance SET check_out_time = ? WHERE id = ? AND check_out_time IS NULL";
		template.update(SQL, time, id);
	}

}
