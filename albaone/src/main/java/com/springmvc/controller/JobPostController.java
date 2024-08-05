package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.domain.JobPost;
import com.springmvc.service.JobPostServiceImpl;

@Controller
public class JobPostController {
	@Autowired
	private JobPostServiceImpl jobPostService;
	
//	채용 공고글 양식 제공
	@GetMapping("/jobposting")
	public String jobPostForm() {
		return "jobPostForm";
	}
	
//	채용 공고 등록
	@PostMapping("/jobposting")
	public String jobPosting(@ModelAttribute("jobPost") JobPost jobPost) {
		jobPostService.jobPosting(jobPost);
		return "redirect:/jobposts"; // 전체 조회 페이지
	}
	
//	채용 공고 조회
	@GetMapping("/jobposts")
	public String jobPostList(Model model) {
		List<JobPost> jobPosts = jobPostService.getAllPosts();
		model.addAttribute("posts", jobPosts);
		return "jobPostList";
	}
}
