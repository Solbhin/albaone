package com.springmvc.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.springmvc.service.*;

@Controller
public class ResumeController
{
	@Autowired
	private ResumeServiceImpl resumeService;
	
	@Autowired
	private UserServiceImpl UserServiceImpl;
	
	//이력서 작성하러 가기
	@GetMapping("/resume")
	public String resumeform(@ModelAttribute("ResumeAdd") Resume resume, HttpSession session, Model model)
	{
		String id =(String)session.getAttribute("id");
		
		//데이터베이스에서 이름 가져가기
		model.addAttribute("name", UserServiceImpl.findUserById(id));
		return "resume";
	}
	
	//이력서 작성
	@PostMapping("/resume")
	public String resumeadd(@ModelAttribute("ResumeAdd") Resume resume,BindingResult result, HttpServletRequest req,HttpSession session)
	{
		String id =(String)session.getAttribute("id");
		
		if(result.hasErrors())
		{return "resume";}
		String root = req.getServletContext().getRealPath("/resources/images");
		MultipartFile myimg = resume.getMyimg();
		String saveName = myimg.getOriginalFilename();
		File saveFile = new File(root ,saveName);
		
		if(myimg !=null && !myimg.isEmpty())
		try 
		{
			myimg.transferTo(saveFile);
			resume.setMyimgName(saveName);
		}
		catch(Exception e)
		{}
		
		resumeService.setmyImg(resume,id);
		return "redirect:/resumereadAll";
	}
	
	//이력서 작성 취소
	@GetMapping("/resumecancel")
	public String resumecancel()
	{
		return "home";
	}
	
	//작성한 이력서 전부 조회
	@GetMapping("/resumereadAll")
	public String resumereadviewAll(Model model,HttpSession session) {
		String id =(String)session.getAttribute("id");
		if(id != null) {
		List<Resume> list=resumeService.getAllresumeList(id);
		model.addAttribute("resumeList",list);
		model.addAttribute("resume_id",id);
		}
		return "resumeviewAll";
		
	}
	
	//이력서 상세보기 
	@GetMapping("/resumeread")
	public String resumereadview(@RequestParam("number")String number,Model model) {
		Resume resumeNumber=resumeService.getResumeNumber(number);
		model.addAttribute("resume",resumeNumber);
		return "resumeview";
	}
	
	//이력서 수정
	@GetMapping("/resumeupdate")
	public String resumeupdate(@ModelAttribute("updateResume")Resume resume,@RequestParam("number")String number,Model model) {
		Resume resumeNumber=resumeService.getResumeNumber(number);
		model.addAttribute("resume",resumeNumber);
		return "updateResume";
	}
	
	@PostMapping("/resumeupdate")
	public String resumeupdate(@ModelAttribute("updateResume")Resume resume, @RequestParam int number) {
		MultipartFile Image = resume.getMyimg();
		if(Image != null && !Image.isEmpty()) {
			try {
				String fname=Image.getOriginalFilename();
				Image.transferTo(new File("/resources/images/"+fname));
				resume.setMyimgName(fname);
			}catch(Exception e) {throw new RuntimeException(" Image saving failed",e);}
		}
		resumeService.setUpdateResume(resume);
		return "redirect:/resumereadAll";
	}
	
	//이력서 삭제
	@RequestMapping(value = "/resumedelete")
	public String resumedelete(@RequestParam("number")String number) {
		resumeService.setDeleteResume(number);
		return "redirect:/resumereadAll";
	}
}

