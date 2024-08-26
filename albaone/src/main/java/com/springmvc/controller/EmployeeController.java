package com.springmvc.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Employee;
import com.springmvc.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;

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
	
//	퇴사
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
		
		employeeService.resignationEmployee(id, businessNumber, formattedDate);
		return null;
	}
}
