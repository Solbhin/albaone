package com.springmvc.repository;

import com.springmvc.domain.Attendance;
import com.springmvc.domain.QRCode;

public interface QRcodeRepository {
	Attendance getLastAttendance(String id);

	void checkIn(String id, String datetime, String businessNumber);

	void checkOut(String id, String time, long flooredMinutes);
}
