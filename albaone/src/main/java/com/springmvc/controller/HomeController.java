package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.domain.JobPost;
import com.springmvc.service.JobPostServiceImpl;


@Controller
public class HomeController {

	@Autowired
	private JobPostServiceImpl jobPostService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<JobPost> recentJopPosts = jobPostService.findRecentJopPosts(3);
		model.addAttribute("recentJopPosts",recentJopPosts);
		
		return "home";
	}

	@GetMapping("/home")
	public String home2(Model model) {
		
		List<JobPost> recentJopPosts = jobPostService.findRecentJopPosts(3);
		model.addAttribute("recentJopPosts",recentJopPosts);
		
		return "home";
	}
	
}
