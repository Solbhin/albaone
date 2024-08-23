package com.springmvc.controller;

import java.util.List;

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
}
