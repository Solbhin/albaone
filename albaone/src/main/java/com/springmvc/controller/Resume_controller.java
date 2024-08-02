package com.springmvc.controller;

import java.io.File;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.domain.Resume;
import com.springmvc.service.ResumeService;

@Controller
public class Resume_controller {
	
	@Autowired
	private ResumeService resumeService;
	
	
	@GetMapping("/resume")
	public String resumeform(@ModelAttribute("ResumeAdd") Resume resume) {
		return "resume";
	}
	@PostMapping("/resume")
	public String resumeadd(@ModelAttribute("ResumeAdd") Resume resume,BindingResult result, HttpServletRequest req) {
	    
		if(result.hasErrors()) {
			return "resume";
	}
		
		String root = req.getServletContext().getRealPath("/resources/images");
		MultipartFile myimg = resume.getMyimg();
		System.out.println(root);
		
		String saveName = myimg.getOriginalFilename();
		File saveFile = new File(root ,saveName);
		
		if(myimg !=null && !myimg.isEmpty())
			try {
				myimg.transferTo(saveFile);
				resume.setMyimgName(saveName);
			}catch(Exception e) {
				
			}
		resumeService.setmyImg(resume);
		return "redirect:/login";
	}
	
	@GetMapping("/resume_cancel")
	public String resume_cancel() {
		return "home";
	}
}
