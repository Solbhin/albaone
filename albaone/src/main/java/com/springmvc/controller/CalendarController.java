package com.springmvc.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalendarController {
	@GetMapping("/calendar")
	public String getCalendar(@RequestParam(value="month", required=false) Integer month,
							  @RequestParam(value="year", required=false) Integer year, Model model) {
		LocalDate currentDate = LocalDate.now();
		if(month==null || year==null) {
			month = currentDate.getMonthValue();
			year = currentDate.getYear();
		}
		YearMonth yearMonth = YearMonth.of(year, month);
		List<Map<String, Object>> daysInMonth = new ArrayList<>();
		
		for(int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
			LocalDate date = LocalDate.of(year, month, day);
			Map<String, Object> dayInfo = new HashMap<>();
			dayInfo.put("dayOfMonth", date.getDayOfMonth());
			dayInfo.put("dayOfWeek", date.getDayOfWeek().getValue());
			daysInMonth.add(dayInfo);
		}
		
		model.addAttribute("days", daysInMonth);
		model.addAttribute("currentMonth", month);
		model.addAttribute("currentYear", year);		
		
		return "calendar";
	}
}
