package com.springmvc.controller;

import java.io.File;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.domain.Resume;
import com.springmvc.service.ResumeService;

@Controller
public class ResumeController {
	
	@Autowired
	private ResumeService resumeService;
	
//	이력서 작성하러 가기
	@GetMapping("/resume")
	public String resumeform(@ModelAttribute("ResumeAdd") Resume resume) {
		return "resume";
	}
//	이력서 작성
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
		return "redirect:/resumereadAll";
	}
//	이력서 작성 취소
	@GetMapping("/resumecancel")
	public String resumecancel() {
		return "home";
	}
//	작성한 이력서 전부 조회
	@GetMapping("/resumereadAll")
	public String resumereadviewAll(Model model) {
		List<Resume> list=resumeService.getAllresumeList();
		model.addAttribute("resumeList",list);
		return "resumeviewAll";
	}
//	이력서 상세보기 
	@GetMapping("/resumeread")
	public String resumereadview(@RequestParam("number")String number,Model model) {
		Resume resumeNumber=resumeService.getResumeNumber(number);
		model.addAttribute("resume",resumeNumber);
		return "resumeview";
	}
//	이력서 수정
	@GetMapping("/resumeupdate")
	public String resumeupdate(@ModelAttribute("updateResume")Resume resume,@RequestParam("number")String number,Model model) {
		Resume resumeNumber=resumeService.getResumeNumber(number);
		model.addAttribute("resume",resumeNumber);
		return "updateResume";
	}
	@PostMapping("/resumeupdate")
	public String resumeupdate(@ModelAttribute("updateResume")Resume resume, @RequestParam int number) {
		MultipartFile Image = resume.getMyimg();
		String rootDirectory = "/resources/images/";
		if(Image != null && !Image.isEmpty()) {
			try {
				String fname=Image.getOriginalFilename();
				Image.transferTo(new File("/resources/images/"+fname));
				resume.setMyimgName(fname);
			}catch(Exception e) {
				throw new RuntimeException(" Image saving failed",e);
			}
		}
		resumeService.setUpdateResume(resume);
		return "redirect:/resumereadAll";
	}
//	이력서 삭제
	@RequestMapping(value = "/resumedelete")
	public String resumedelete(Model model,@RequestParam("number")String number) {
		resumeService.setDeleteResume(number);
		return "redirect:/resumereadAll";
	}
}

