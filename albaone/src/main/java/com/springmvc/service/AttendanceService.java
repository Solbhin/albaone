package com.springmvc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.springmvc.domain.Attendance;

public interface AttendanceService {
	List<Attendance> getAllAttendances(String id);

	List<Attendance> getAttendancesByBusinessNumber(String businessNumber);
	
	void deleteAttendance(String id);

	void addAttendance(Attendance attendance);

	void editAttendance(Attendance attendance, LocalDateTime checkInTime);

	int get3MonthWorkMinutes(String id, String businessNumber, LocalDate dateAll1, LocalDate dateAll2);
}
