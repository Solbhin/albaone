package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Employee;
import com.springmvc.domain.Severance;
import com.springmvc.service.EmployeeServiceImpl;
import com.springmvc.service.SeveranceServiceImpl;

@Controller
public class SeveranceController {
	@Autowired
	private EmployeeServiceImpl employeeService;

	@Autowired
	private SeveranceServiceImpl severanceService;

	// 퇴직금 상세 조회
	@GetMapping("severance")
	public String Severancecreate(@RequestParam String id, @RequestParam(required = false) String businessNumber,
			HttpSession session, Model model) {
		if (businessNumber == null) { // null이면 기업회원
			businessNumber = (String) session.getAttribute("businessNumber");
		}
		
		Severance severance = severanceService.getSeverance(id, businessNumber);
		
		model.addAttribute("name", severance.getName());
		model.addAttribute("total3MonthSalary", severance.getTotal3MonthSalary());
		model.addAttribute("averageWage", severance.getAverageWage());
		model.addAttribute("severance", severance.getSeverance());

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
