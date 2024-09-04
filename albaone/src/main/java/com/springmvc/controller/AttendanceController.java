package com.springmvc.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.Session;
import com.springmvc.domain.Attendance;
import com.springmvc.domain.Employee;
import com.springmvc.service.AttendanceServiceImpl;
import com.springmvc.service.UserServiceImpl;
import com.springmvc.service.EmployeeServiceImpl;

@Controller
public class AttendanceController {
	@Autowired
	private AttendanceServiceImpl attendanceService;

	@Autowired
	private EmployeeServiceImpl employeeService;

	@Autowired
	private UserServiceImpl userService;

//	근태 기록 조회
	@GetMapping("/attendanceCalendar")
	public String getCalendar(@RequestParam(value = "month", required = false) Integer month,
			@RequestParam(value = "year", required = false) Integer year, HttpSession session, Model model) {
//		현재 날짜 불러오기
		LocalDate currentDate = LocalDate.now();
		if (month == null || year == null) {
			month = currentDate.getMonthValue();
			year = currentDate.getYear();
		}

//	    월이 넘어가면 연도가 바뀌게 설정
		if (month < 1) {
			month = 12;
			year -= 1;
		} else if (month > 12) {
			month = 1;
			year += 1;
		}
		YearMonth yearMonth = YearMonth.of(year, month);
		List<Map<String, Object>> daysInMonth = new ArrayList<>();

//	    날짜 정보 수집
		for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
			LocalDate date = LocalDate.of(year, month, day);
			Map<String, Object> dayInfo = new HashMap<>();
			dayInfo.put("date", date);
			dayInfo.put("dayOfMonth", day);
			dayInfo.put("dayOfWeek", (date.getDayOfWeek().getValue() % 7) + 1);
			daysInMonth.add(dayInfo);
		}
		model.addAttribute("currentMonth", month);
		model.addAttribute("currentYear", year);
		model.addAttribute("days", daysInMonth);

//	    출석 정보 가져오기
		String businessNumber = (String) session.getAttribute("businessNumber");
		List<Attendance> listOfAttendance = null;

		if (businessNumber != null) { // 기업회원
			listOfAttendance = attendanceService.getAttendancesByBusinessNumber(businessNumber);
			model.addAttribute("listOfAttendance", listOfAttendance);

			return "attendanceCalendar";
		} else { // 개인회원
			String id = (String) session.getAttribute("id");
			listOfAttendance = attendanceService.getAllAttendances(id);
			model.addAttribute("listOfAttendance", listOfAttendance);

			return "attendanceCalendar";
		}
	}

//	근태 기록 추가 양식 제공
	@GetMapping("addAttendance")
	public String addAttendanceForm(HttpSession session, Model model) {
		String businessNumber = (String) session.getAttribute("businessNumber");
		List<Employee> empolyeeList = employeeService.getAllEmployee(businessNumber);
		model.addAttribute("empolyeeList", empolyeeList);

		return "attendanceAdd";
	}

//	근태 기록 추가
	@PostMapping("attendanceAdd")
	public String addAttendance(@RequestParam String id, String selectDate, String inTime, String outTime,
			HttpSession session) {
//		String -> LocalDateTime 변환
		Attendance attendance = new Attendance();
		LocalDate localDate = LocalDate.parse(selectDate);
		LocalTime checkinTime = LocalTime.parse(inTime);
		LocalTime checkoutTime = LocalTime.parse(outTime);
		LocalDateTime checkInDateTime = LocalDateTime.of(localDate, checkinTime);
		LocalDateTime checkOutDateTime = LocalDateTime.of(localDate, checkoutTime);
		long minutesWorked = Duration.between(checkInDateTime, checkOutDateTime).toMinutes();
		long flooredMinutes = (minutesWorked / 10) * 10;

		attendance.setId(id);
		attendance.setBusinessNumber(String.valueOf(session.getAttribute("businessNumber")));
		attendance.setCheckInTime(checkInDateTime);
		attendance.setCheckOutTime(checkOutDateTime);
		attendance.setWorkHours(flooredMinutes);

		attendanceService.addAttendance(attendance);

		return "redirect:/attendanceCalendar";
	}

//	근태 기록 수정 양식 제공
	@GetMapping("attendanceEdit")
	public String editAttendanceForm(@RequestParam String id, String checkInTime, @RequestParam(required = false) String checkOutTime, Model model) {
		LocalDateTime localDateTime = LocalDateTime.parse(checkInTime);
		LocalDate localDate = localDateTime.toLocalDate();
		LocalTime localTime = localDateTime.toLocalTime();
		String name = userService.getUserName(id);
		
		if(checkOutTime!=null) {
			LocalDateTime localDateTime2 = LocalDateTime.parse(checkOutTime);
			LocalTime localOutTime = localDateTime2.toLocalTime();
			
			model.addAttribute("localOutTime", localOutTime);
		}
		
		System.out.println(name);
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println("기준:" + checkInTime);

		model.addAttribute("localDate", localDate);
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("localTime", localTime);
		model.addAttribute("checkInTime", checkInTime);
		model.addAttribute("checkOutTime", checkOutTime);

		return "attendanceEditForm";
	}

//	근태 기록 수정
	@PostMapping("attendanceEdit")
	public String editAttendance(String id, String selectDate, String inTime, String outTime, String checkInTime,
			HttpSession session) {
		Attendance attendance = new Attendance();
		LocalDate localDate = LocalDate.parse(selectDate);
		LocalTime checkinTime = LocalTime.parse(inTime);
		LocalDateTime checkInDateTime = LocalDateTime.of(localDate, checkinTime);

		attendance.setId(id);
		attendance.setBusinessNumber(String.valueOf(session.getAttribute("businessNumber")));
		attendance.setCheckInTime(checkInDateTime);

		if (outTime != null && !outTime.isEmpty()) {
			LocalTime checkoutTime = LocalTime.parse(outTime);
			LocalDateTime checkOutDateTime = LocalDateTime.of(localDate, checkoutTime);
			long minutesWorked = Duration.between(checkInDateTime, checkOutDateTime).toMinutes();
			long flooredMinutes = (minutesWorked / 10) * 10;

			attendance.setCheckOutTime(checkOutDateTime);
			attendance.setWorkHours(flooredMinutes);
		} else {
			attendance.setCheckOutTime(null);
		}

		LocalDateTime ldtCheckInTime = LocalDateTime.parse(checkInTime);

		System.out.println("기준 :" + checkInTime);

		attendanceService.editAttendance(attendance, ldtCheckInTime);

		return "redirect:/attendanceCalendar";
	}

//	계산기
	@GetMapping("calculator")
	public String calculator() {
		return "calculator";
	}
}
