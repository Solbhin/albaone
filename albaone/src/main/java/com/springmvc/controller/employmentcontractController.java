package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	//근로계약서 조회 폼으로 이동
	@GetMapping("/searchcontract")
	public String parttimesearch()
	{
		return "searchcontract";
	}
	
	// 알바생명으로 모든 계약서 조회
	@PostMapping("/contracts")
	public String getContractsByPartTimeName(@RequestParam(value = "parttimename") String parttimename, Model model)
	{
	    if (parttimename != null && !parttimename.isEmpty())
	    {
	        List<employmentcontract> contracts = employmentcontractService.findAllByPartTimeName(parttimename);
	        if (!contracts.isEmpty())
	        {
	            model.addAttribute("contracts", contracts);
	        }
	        else
	        {
	            model.addAttribute("error", "해당 알바생명의 계약서가 존재하지 않습니다.");
	        }
	    }
	    return "employmentcontractlist"; // 뷰 이름
	}

	
	//해당 계약서 삭제-일단 리드가 되야됨
	@GetMapping("/employmentcontractDelete")
	public String employmentcontractUpdate()
	{
		return "redirect:home";
	}
}
