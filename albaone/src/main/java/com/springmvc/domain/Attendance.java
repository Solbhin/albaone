package com.springmvc.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Attendance
{
	private String id; 					// 개인회원 식별
	private String companyName; 		// 근무지 식별
	private String name; 				// 알바생 식별
	private LocalDateTime checkInTime; 	// 출근시간
	private LocalDateTime checkOutTime; // 퇴근시간
	
	public String getFormattedCheckInTime() {
		DateTimeFormatter formmater = DateTimeFormatter.ofPattern("HH:mm");
		return checkInTime.format(formmater);
	}
	
	public String getFormattedCheckOutTime() {
		DateTimeFormatter formmater = DateTimeFormatter.ofPattern("HH:mm");
		return checkOutTime.format(formmater);
	}
	
	public String getWorkHours() {
		long minutesWorked = Duration.between(checkInTime, checkOutTime).toMinutes();
		
		long flooredMinutes = (minutesWorked/10)*10;
		
		if(flooredMinutes >= 60) {
			return (flooredMinutes/60) + "시간 " + (flooredMinutes % 60) + "분"; 
		}
		return flooredMinutes + "분";
	}
	
	public LocalDate getDate() {
		return checkInTime.toLocalDate();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

}
