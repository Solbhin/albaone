package com.springmvc.controller;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Employee;
import com.springmvc.service.EmployeeServiceImpl;
import com.springmvc.service.AttendanceServiceImpl;

@Controller
public class SeveranceController {
	// 퇴직금 계산을 위해 계약서 연결
	@Autowired
	private EmployeeServiceImpl employeeService;

	@Autowired
	private AttendanceServiceImpl attendanceService;

	// 퇴직금 상세 조회
	@GetMapping("severance")
	public String Severancecreate(@RequestParam String id, @RequestParam(required = false) String businessNumber,
			HttpSession session, Model model) {
		if (businessNumber == null) { // null이면 기업회원
			businessNumber = (String) session.getAttribute("businessNumber");
		}
		Employee employee = employeeService.getOneResignee(id, businessNumber);
		LocalDate resignationDate = employee.getResignationDate();
		int resignYear = resignationDate.getYear(); // 퇴직일자의 년도
		int resignMonthValue = resignationDate.getMonthValue(); // 퇴직일자의 월 값
		int resignDay = resignationDate.getDayOfMonth(); // 퇴직일자의 일 값

//		퇴직전 3개월 기간
		LocalDate dateAll1 = LocalDate.of(resignYear, resignMonthValue - 3, resignDay);
		LocalDate dateAll2 = LocalDate.of(resignYear, resignMonthValue, resignDay - 1);
		long periodAll = ChronoUnit.DAYS.between(dateAll1, dateAll2) + 1;

		int wage = 9860; // 시급
		int workMinutes = attendanceService.get3MonthWorkMinutes(id, businessNumber, dateAll1, dateAll2); // 3개월간 근무시간
		long total3MonthSalary = (long) ((float) workMinutes / 60 * wage); // 3개월간 급여 합계
		long averageWage = total3MonthSalary / periodAll; // 1일 평균 임금
		long result = averageWage * 30 * employee.getEmploymentPeriod() / 365; // 퇴직금

//		디버깅
//		System.out.println("시작날짜: " + dateAll1);
//		System.out.println("끝날짜: " + dateAll2);
//		System.out.println("기간: " + periodAll);
//		System.out.println("근무시간 "+workMinutes);
//		System.out.println("총 급여: "+total3MonthSalary);
//		System.out.println("1일 평균임금: " + averageWage);
//		System.out.println("재직일자: "+employee.getEmploymentPeriod()); 
//		System.out.println("퇴직금: "+severance);
//		System.out.println("이름: "+employee.getName());

		NumberFormat numberFormat = NumberFormat.getInstance();
		String total = numberFormat.format(total3MonthSalary);
		String average = numberFormat.format(averageWage);
		String severance = numberFormat.format(result);

		model.addAttribute("name", employee.getName());
		model.addAttribute("total3MonthSalary", total);
		model.addAttribute("averageWage", average);
		model.addAttribute("severance", severance);

		return "severanceCheck";
	}

//	개인회원: 퇴직금 조회
	@GetMapping("severancePersonal")
	public String severancePersonal(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");

		List<Employee> resignationHistory = employeeService.getResignationHistory(id);

		if (resignationHistory == null) {
			model.addAttribute("message", "퇴사내역이 없습니다.");

			return "errorPage";
		}

//		System.out.println("재직일수 1번: " + resignationHistory.get(0).getBusinessNumber());
//		System.out.println("재직일수 2번: "+resignationHistory.get(1).getEmploymentPeriod());
//		System.out.println("사용자ID : " + id);
//		System.out.println(resignationHistory);

		model.addAttribute("resignationHistory", resignationHistory);

		return "resigneePersonal";
	}
}
