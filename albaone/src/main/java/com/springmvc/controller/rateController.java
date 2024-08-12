package com.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.springmvc.domain.Albarate;
import com.springmvc.service.AlbarateServiceImpl;

@Controller
public class rateController
{
	@Autowired
	private AlbarateServiceImpl AlbarateServiceImpl;
	
	@GetMapping("/writeAlbarate")
	public String Albarateform()
	{
		return "Albarateform";
	}

	@PostMapping("/writeAlbarate")
	public String Albarate(@ModelAttribute("Albarate") Albarate albarate, Model model)
	{
		System.out.println(albarate.getRating());
		
	    if ("positive".equals(albarate.getRating()))
	    {
	    	
	        albarate.setCompany(1); //사장 평가 +1
	    }
	    else if ("negative".equals(albarate.getRating()))
	    {
	        albarate.setCompany(-1); //사장 평가 -1
	    }
	    //리파지토리
	    AlbarateServiceImpl.update(albarate);
	    return "Albarateform";
	}

	//등급 조회
	@GetMapping("/ReadAlbarate")
	public String ReadAlbarate(HttpSession session, Model model)
	{
		//알바생아이디를 세션에서 가져옴
		//세션쪽 확인
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		model.addAttribute("read",AlbarateServiceImpl.read(id));
		return "ReadAlbarate";
	}
}
