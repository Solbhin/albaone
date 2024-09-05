package com.springmvc.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Attendance {
	private String id; 					// 개인회원 식별
	private String businessNumber;
	private String companyName; 		// 근무지 식별
	private String name; 				// 알바생 식별
	private LocalDateTime checkInTime; 	// 출근시간
	private LocalDateTime checkOutTime; // 퇴근시간
	private long workHours; 			// 근무 시간
	private String reason; // 사유
	private String edit; //수정
	
	public String getFormattedCheckInTime() {
		DateTimeFormatter formmater = DateTimeFormatter.ofPattern("HH:mm");
		return checkInTime.format(formmater);
	}
	
	public String getFormattedCheckOutTime() {
		DateTimeFormatter formmater = DateTimeFormatter.ofPattern("HH:mm");
		return checkOutTime.format(formmater);
	}
	
	public String getTime() {
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
	
	public String getBusinessNumber() {
		return businessNumber;
	}
	
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
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

	public long getWorkHours() {
		return workHours;
	}

	public void setWorkHours(long workHours) {
		this.workHours = workHours;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}
	
	
}
