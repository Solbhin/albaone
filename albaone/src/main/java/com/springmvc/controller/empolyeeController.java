package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Empolyee;
import com.springmvc.service.empolyeeServiceImpl;

@Controller
public class empolyeeController {
	@Autowired
	private empolyeeServiceImpl empolyeeService;
	
	@GetMapping("empolyeeList")
	public String empolyeeList(@RequestParam String businessNumber, Model model) {
		List<Empolyee> empolyeeList = empolyeeService.getAllEmpolyee(businessNumber);
		model.addAttribute("empolyeeList", empolyeeList);
		return "empolyeeList";
	}
}
