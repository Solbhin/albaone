package com.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.springmvc.service.*;

@Controller
public class rateController
{
	@Autowired
	private AlbarateServiceImpl AlbarateServiceImpl;
	
	@Autowired
	private AttendanceServiceImpl AttendanceServiceImpl;
	
	// 알바생이 자기 등급 조회
	@GetMapping("/ReadAlbarate")
	public String ReadAlbarate(HttpSession session, Model model)
	{
		// 알바생아이디를 세션에서 가져옴
		// 세션쪽 확인
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		
		AttendanceServiceImpl.getAllAttendances(id);
		
		model.addAttribute("readList", AttendanceServiceImpl.getAllAttendances(id));
		return "ReadAlbarate";
	}

}
