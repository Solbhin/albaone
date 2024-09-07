package com.springmvc.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
public class ResumeController {
	@Autowired
	private ResumeServiceImpl resumeService;

	@Autowired
	private UserServiceImpl UserServiceImpl;

	// 이력서 작성하러 가기
	@GetMapping("/resume")
	public String resumeform(@ModelAttribute("ResumeAdd") Resume resume, HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");

		// 데이터베이스에서 이름 가져가기
		model.addAttribute("name", UserServiceImpl.findUserById(id));
		return "resume";
	}

	// 이력서 작성
	@PostMapping("/resume")
	public String resumeadd(@ModelAttribute("ResumeAdd") Resume resume, BindingResult result, HttpServletRequest req,
			HttpSession session) {
		String id = (String) session.getAttribute("id");

		if (result.hasErrors()) {
			return "resume";
		}
		String root = req.getServletContext().getRealPath("/resources/images");
		MultipartFile myimg = resume.getMyimg();
		String saveName = myimg.getOriginalFilename();
		File saveFile = new File(root, saveName);

		if (myimg != null && !myimg.isEmpty())
			try {
				myimg.transferTo(saveFile);
				resume.setMyimgName(saveName);
			} catch (Exception e) {
			}

		resumeService.setmyImg(resume, id);
		return "redirect:/resumereadAll";
	}

	// 이력서 작성 취소
	@GetMapping("/resumecancel")
	public String resumecancel() {
		return "home";
	}

	// 작성한 이력서 전부 조회
	@GetMapping("/resumereadAll")
	public String resumereadviewAll(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		if (id != null) {
			List<Resume> list = resumeService.getAllresumeList(id);
			model.addAttribute("resumeList", list);
			model.addAttribute("resume_id", id);
		}
		return "resumeviewAll";

	}

	// 이력서 상세보기
	@GetMapping("/resumeread")
	public String resumereadview(@RequestParam("number") String number, Model model) {
		Resume resume = resumeService.getResumeNumber(number);
		
		List<String> schools = Arrays.asList(resume.getSchool().split(","));
		List<String> periods = Arrays.asList(resume.getPeriod().split(","));
		List<String> majors = Arrays.asList(resume.getMajor().split(","));
		List<String> jopTitles = Arrays.asList(resume.getJob_title().split(","));
		List<String> experiencePeriods = Arrays.asList(resume.getExperience_period().split(","));
		List<String> mainWorks = Arrays.asList(resume.getMain_work().split(","));
	
		
		model.addAttribute("resume", resume);
		model.addAttribute("schools",schools);
		model.addAttribute("periods",periods);
		model.addAttribute("jopTitles",jopTitles);
		model.addAttribute("majors",majors);
		model.addAttribute("experiencePeriods",experiencePeriods);
		model.addAttribute("mainWorks",mainWorks);
		return "resumeview";
	}
	
	// 이력서 수정 폼 표시
	@GetMapping("/resumeupdate")
	public String resumeUpdateForm(@RequestParam("number") String number, Model model) {
	    Resume resume = resumeService.getResumeNumber(number);
	    
	    // 학력사항과 경력사항 리스트 변환
	    List<String> schools = Arrays.asList(resume.getSchool().split(","));
	    List<String> periods = Arrays.asList(resume.getPeriod().split(","));
	    List<String> majors = Arrays.asList(resume.getMajor().split(","));
	    List<String> jopTitles = Arrays.asList(resume.getJob_title().split(","));
	    List<String> experiencePeriods = Arrays.asList(resume.getExperience_period().split(","));
	    List<String> mainWorks = Arrays.asList(resume.getMain_work().split(","));

	    // 모델에 데이터 추가
	    model.addAttribute("resume", resume);
	    model.addAttribute("schools", schools);
	    model.addAttribute("periods", periods);
	    model.addAttribute("majors", majors);
	    model.addAttribute("jobTitles", jopTitles);
	    model.addAttribute("experiencePeriods", experiencePeriods);
	    model.addAttribute("mainWorks", mainWorks);

	    return "updateResume";
	}
	
	// 이력서 수정
	@PostMapping("/resumeupdate")
	public String resumeupdate(@ModelAttribute("updateResume") Resume resume,
	                           @RequestParam("number") String number,
	                           @RequestParam(value = "schools[]", required = false) List<String> schools,
	                           @RequestParam(value = "periods[]", required = false) List<String> periods,
	                           @RequestParam(value = "majors[]", required = false) List<String> majors,
	                           @RequestParam(value = "jobTitles[]", required = false) List<String> jobTitles,
	                           @RequestParam(value = "experiencePeriods[]", required = false) List<String> experiencePeriods,
	                           @RequestParam(value = "mainWorks[]", required = false) List<String> mainWorks) {
		
	    System.out.println("schools: " + schools);
	    System.out.println("periods: " + periods);
	    System.out.println("majors: " + majors);
	    System.out.println("jobTitles: " + jobTitles);
	    System.out.println("experiencePeriods: " + experiencePeriods);
	    System.out.println("mainWorks: " + mainWorks);
		
	    
	    // 나머지 처리
	    resume.setSchool(String.join(",", schools));
	    resume.setPeriod(String.join(",", periods));
	    resume.setMajor(String.join(",", majors));
	    resume.setJob_title(String.join(",", jobTitles));
	    resume.setExperience_period(String.join(",", experiencePeriods));
	    resume.setMain_work(String.join(",", mainWorks));
	    
	    resumeService.setUpdateResume(resume);
	    return "redirect:/resumereadAll";
	}

	// 이력서 삭제
	@RequestMapping(value = "/resumedelete")
	public String resumedelete(@RequestParam("number") String number) {
		resumeService.setDeleteResume(number);
		return "redirect:/resumereadAll";
	}
}
