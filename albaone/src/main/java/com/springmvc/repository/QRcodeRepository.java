package com.springmvc.repository;

import com.springmvc.domain.Attendance;

public interface QRcodeRepository {
	Attendance getLastAttendance(String id);

	void checkIn(String id, String datetime, String businessNumber);

	void checkOut(String id, String time, long flooredMinutes);
}
