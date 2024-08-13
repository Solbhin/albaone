package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.domain.employmentcontract;
import com.springmvc.service.employmentcontractServiceImpl;

@Controller
public class employmentcontractController
{
	@Autowired
	private employmentcontractServiceImpl employmentcontractService;
	
	//get 요청 발생시 계약서 폼 제공
	@GetMapping("/employmentcontract")
	public String employmentcontractform()
	{
		return "employmentcontractform";
	}
	
	//근로계약서 폼에서 요청 발생시 create
	@PostMapping("/employmentcontract")
	public String employmentcontractend(@ModelAttribute("employment") employmentcontract employmentcontract, BindingResult result)
	{
		System.out.println("근로계약서 폼 도착");
		System.out.println(employmentcontract);
		employmentcontractService.create(employmentcontract);
		return "redirect:home";
	}
	
	//근로계약서 업데이트 get 요청 발생시 폼 제공
	@GetMapping("/employmentcontractUpdate")
	public String employmentcontractUpdatefrom()
	{
		return "employmentcontractUpdate";
	}
	
	//근로계약서 업데이드 폼
	@PostMapping("/employmentcontractUpdate")
	public String employmentcontractUpdate(@ModelAttribute("employment") employmentcontract employmentcontract, BindingResult result)
	{
		employmentcontractService.update(employmentcontract);
		return "redirect:home";
	}
}
