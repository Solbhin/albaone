package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.JobPost;
import com.springmvc.service.JobPostServiceImpl;

@Controller
public class JobPostController
{
	@Autowired
	private JobPostServiceImpl jobPostService;

	//채용 공고글 양식 제공
	@GetMapping("/jobposting")
	public String jobPostForm()
	{
		return "jobPostForm";
	}

	//채용 공고 등록
	@PostMapping("/jobposting")
	public String jobPosting(@ModelAttribute("jobPost") JobPost jobPost, HttpSession session)
	{
		String id = (String) session.getAttribute("id");
		jobPostService.jobPosting(jobPost, id);
		return "redirect:/jobposts?page=1"; // 전체 조회 페이지
	}

	//채용 공고 조회
	@GetMapping("/jobposts")
	public String jobPostList(@RequestParam int page, Model model)
	{
		List<JobPost> jobPosts = jobPostService.getAllPosts(page);
		int totalPosts = jobPostService.getTotalPosts();
		model.addAttribute("jobPosts", jobPosts);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPosts", totalPosts);
		return "jobPostList";
	}

	//상세보기
	@GetMapping("/jobpost")
	public String jobPost(@RequestParam int postNumber, Model model)
	{
		JobPost jobPost = jobPostService.getPostDetail(postNumber);
		model.addAttribute("jobPost", jobPost);
		return "jobPost";
	}

//	내가 쓴 글 보기
	@GetMapping("/myJobPost")
	public String myJobPost(@RequestParam int page, HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		List<JobPost> jobPosts = jobPostService.getMyPosts(page, id);
		int totalPosts = jobPostService.getTotalPosts();
		model.addAttribute("jobPosts", jobPosts);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPosts", totalPosts);
		return "myJobPosts";
	}

//	게시글 수정
	@GetMapping("/editjobpost")
	public String editJobPostForm(@RequestParam int postNumber) {
		return "redirect:/jobposts?page=1";
	}

//	게시글 수정 폼
	@GetMapping("/editJobPost")
	public String jobPostEditForm(@RequestParam int postNumber, Model model) {
		JobPost jobPost = jobPostService.getPostDetail(postNumber);
		model.addAttribute("jobPost", jobPost);
		return "jobPostEditForm";
	}

//	게시글 수정
	@PostMapping("/editJobPost")
	public String editJobPost(@ModelAttribute JobPost jobPost) {
		jobPostService.updatePost(jobPost);
		return "redirect:/jobposts?page=1";
	}

//	게시글 삭제
	@GetMapping("/deleteJobPost")
	public String deleteJobPost(@RequestParam int postNumber) {
		jobPostService.deletePost(postNumber);
		return "redirect:/jobposts?page=1";
	}

}
