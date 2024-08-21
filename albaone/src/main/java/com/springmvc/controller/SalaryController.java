package com.springmvc.controller;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.Salary;
import com.springmvc.service.SalaryServiceImpl;

@Controller
public class SalaryController {
	@Autowired
	private SalaryServiceImpl salaryService;

//	개인회원: 급여 조회
	@GetMapping("/salaryPersonal")
	public String salaryPersonal(@RequestParam(required = false) YearMonth yearMonth, HttpSession session,
			Model model) {
		if (yearMonth == null) {
			yearMonth = YearMonth.now();
		}

		int year = yearMonth.getYear();
		int month = yearMonth.getMonthValue();
		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());
		String id = (String) session.getAttribute("id");

		int wage = 9860; // 시급
		int workHours = salaryService.getPersonalSalary(id, firstDayOfMonth, lastDayOfMonth) / 60; // 근무시간(시간단위)
		float workMinutes = salaryService.getPersonalSalary(id, firstDayOfMonth, lastDayOfMonth) % 60; // 근무시간(분단위)

		if (workHours == 0) {
			model.addAttribute("message", "근무 기록이 없습니다.");
			return "errorPage";
		}

		int Salary = (workHours * wage) + (int) (workMinutes / 60 * wage); // 급여 계산
		int benefit = (int) ((workHours * 60 + workMinutes) / 60 / 40 * 8 * wage); // 주휴수당 계산

//		천단위 구분 기호
		NumberFormat numberFormat = NumberFormat.getInstance();
		String formattedWage = numberFormat.format(wage);
		String formattedSalary = numberFormat.format(Salary);
		String formattedBenefit = numberFormat.format(benefit);
		String formattedTotalSalary = numberFormat.format(Salary + benefit);

		model.addAttribute("yearMonth", yearMonth);
		model.addAttribute("workHours", workHours);
		model.addAttribute("workMinutes", (int) workMinutes);
		model.addAttribute("wage", formattedWage);
		model.addAttribute("salary", formattedSalary);
		model.addAttribute("benefit", formattedBenefit);
		model.addAttribute("totalSalary", formattedTotalSalary);

		return "salaryPersonal";
	}

//	기업회원: 모든 알바생 급여 조회
	@GetMapping("/salaryBusiness")
	public String salaryBusiness(@RequestParam(required = false) YearMonth yearMonth, HttpSession session,
			Model model) {
		String businessNumber = (String) session.getAttribute("businessNumber");
		if (yearMonth == null) {
			yearMonth = YearMonth.now();
		}

		int year = yearMonth.getYear();
		int month = yearMonth.getMonthValue();
		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());

		List<Salary> listOfSalary = salaryService.getBusinessSalary(businessNumber, firstDayOfMonth, lastDayOfMonth);

		model.addAttribute("yearMonth", yearMonth);
		model.addAttribute("listOfSalary", listOfSalary);

		return "salaryBusiness";
	}

//	@GetMapping("salaryPersonal/data")
//	@ResponseBody
//	public Map<String, Object> salaryPersonalData(@RequestParam(required = false) YearMonth yearMonth, HttpSession session) {
//		int year = yearMonth.getYear();
//		int month = yearMonth.getMonthValue();
//		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
//		LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());
//		String id = (String) session.getAttribute("id");
//		
//		int wage = 9860;
//		int workHours = salaryService.getPersonalSalary(id, firstDayOfMonth, lastDayOfMonth) / 60;
//		int benefit = (int) ((float) workHours /40 * 8 * 10000);
//		int Salary = workHours * minimumWage;
//		
//		NumberFormat numberFormat = NumberFormat.getInstance();
//		String formattedMinimumWage = numberFormat.format(minimumWage);
//		String formattedSalary = numberFormat.format(Salary);
//		String formattedBenefit = numberFormat.format(benefit);
//		String formattedTotalSalary = numberFormat.format(Salary+benefit);
//		
//		Map<String, Object> response = new HashMap<>();
//		response.put("yearMonth", yearMonth);
//		response.put("workHours", workHours);
//		response.put("minimumWage", formattedMinimumWage);
//		response.put("salary", formattedSalary);
//		response.put("benefit", formattedBenefit);
//		response.put("totalSalary", formattedTotalSalary);
//		System.out.println("Response: "+response)
//		
//		return response;
//	}

}
