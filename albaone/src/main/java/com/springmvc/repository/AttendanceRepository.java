package com.springmvc.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.springmvc.domain.Attendance;

public interface AttendanceRepository {
	List<Attendance> getAllAttendances(String id);

	List<Attendance> getAttendancesByBusinessNumber(String businessNumber);

	void deleteAttendance(String id);

	void addAttendance(Attendance attendance);

	void editAttendance(Attendance attendance, LocalDateTime checkInTime);
}
