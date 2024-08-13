package com.springmvc.repository;

import com.springmvc.domain.Attendance;
import com.springmvc.domain.QRCode;

public interface QRcodeRepository
{
//	void create(QRCode qrdto);

//	QRCode read(String id);

//	void update(QRCode qrdto);

	Attendance getLastAttendance(String id);

	void checkOut(String id, String time);

	void checkIn(String id, String datetime);
}
