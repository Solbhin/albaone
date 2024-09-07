package com.springmvc.controller;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Employee;
import com.springmvc.service.AttendanceServiceImpl;
import com.springmvc.service.EmployeeServiceImpl;
import com.springmvc.service.SeveranceServiceImpl;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@Autowired
	private AttendanceServiceImpl attendanceService;
	
	@Autowired
	private SeveranceServiceImpl severanceService;
	
//	내 사업장 알바생 조회
	@GetMapping("employeeList")
	public String empolyeeList(@RequestParam String businessNumber, Model model) {
		List<Employee> employeeList = employeeService.getAllEmployee(businessNumber);
		model.addAttribute("employeeList", employeeList);
		return "employeeList";
	}

//	내 직장 조회
	@GetMapping("companyList")
	public String myCompany(@RequestParam String id, Model model) {
		List<Employee> companyList = employeeService.getMyCompany(id);
		model.addAttribute("companyList", companyList);
		return "employeeList";
	}
	
//	퇴사 및 퇴직금 생성
	@GetMapping("resignation")
	public String resignation(@RequestParam String id, 
			@RequestParam String resignationDate,
			HttpSession session) {
		
		String businessNumber = (String) session.getAttribute("businessNumber");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate formattedDate = LocalDate.parse(resignationDate, formatter);
		
		System.out.println("퇴사 ID: "+id);
		System.out.println("사업장: "+businessNumber);
		System.out.println("퇴사일자: "+formattedDate);
		
		employeeService.resignationEmployee(id, businessNumber, formattedDate); // 퇴직일자 업데이트
		
//		퇴직금 지급여부 확인 후 생성
		Employee employee = employeeService.getOneResignee(id, businessNumber);
		if(employee.getEmploymentPeriod()>365) {
			int resignYear = formattedDate.getYear(); // 퇴직일자의 년도
			int resignMonthValue = formattedDate.getMonthValue(); // 퇴직일자의 월 값
			int resignDay = formattedDate.getDayOfMonth(); // 퇴직일자의 일 값
	
	//		퇴직전 3개월 기간
			LocalDate dateAll1 = LocalDate.of(resignYear, resignMonthValue - 3, resignDay);
			LocalDate dateAll2 = LocalDate.of(resignYear, resignMonthValue, resignDay - 1);
			long periodAll = ChronoUnit.DAYS.between(dateAll1, dateAll2) + 1;
	
			int wage = 9860; // 시급
			int workMinutes = attendanceService.get3MonthWorkMinutes(id, businessNumber, dateAll1, dateAll2); // 3개월간 근무시간
			long total3MonthSalary = (long) ((float) workMinutes / 60 * wage); // 3개월간 급여 합계
			long averageWage = total3MonthSalary / periodAll; // 1일 평균 임금
			long result = averageWage * 30 * employee.getEmploymentPeriod() / 365; // 퇴직금
			
			NumberFormat numberFormat = NumberFormat.getInstance();
			String total = numberFormat.format(total3MonthSalary);
			String average = numberFormat.format(averageWage);
			String severance = numberFormat.format(result);
			
	//		디버깅
			System.out.println("시작날짜: " + dateAll1);
			System.out.println("끝날짜: " + dateAll2);
			System.out.println("기간: " + periodAll);
			System.out.println("근무시간 "+workMinutes);
			System.out.println("총 급여: "+total3MonthSalary);
			System.out.println("1일 평균임금: " + averageWage);
			System.out.println("재직일자: "+employee.getEmploymentPeriod()); 
			System.out.println("퇴직금: "+severance);
			System.out.println("이름: "+employee.getName());
		
			severanceService.createSeverance(id, businessNumber, employee.getHireDate(), formattedDate, periodAll, total, average, severance);
		}

		return "redirect:/resignee";
	}
	
//	퇴사자 조회
	@GetMapping("resignee")
	public String resignee(HttpSession session, Model model) {
		String businessNumber = (String) session.getAttribute("businessNumber");
		List<Employee> resigneeList = employeeService.getAllResignee(businessNumber);
		
		model.addAttribute("resigneeList", resigneeList);
		
		return "resignee";
	}
}
