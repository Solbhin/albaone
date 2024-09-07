package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Apply;
import com.springmvc.domain.JobPost;
import com.springmvc.domain.Resume;
import com.springmvc.service.*;

@Controller
public class ApplyforController
{

    @Autowired
    private ResumeServiceImpl resumeService;

    @Autowired
    private ApplyServiceImpl applyService;
    
    @Autowired
    private JobPostServiceImpl jobPostService;
    
    // 채용 지원할 목록 조회
    @GetMapping("/applyresumeList")
    public String showResumeApplyList(@RequestParam int postNumber,Model model,HttpSession session)
    {
        String userId=(String) session.getAttribute("id");
        List<Resume> resumes=resumeService.getAllresumeList(userId);
        model.addAttribute("resumes",resumes);
        model.addAttribute("postNumber",postNumber);
    	return "applyresumeList";
    }
    
    @GetMapping("/apply")
    public String applyForm(@RequestParam("postNumber")int postNumber,@RequestParam("resume_id")String resumeId,Model model,HttpSession session) {
    	String userId=(String) session.getAttribute("id");
    	List<Resume> resumes=resumeService.getAllresumeList(userId); 
    	model.addAttribute("postNumber", postNumber);
    	model.addAttribute("resumeId", resumeId);
    	model.addAttribute("resumes",resumes);
    	return "applyadd";
    }
    
    // 지원서 제출 처리
    @PostMapping("/apply")
    public String applyForJob(@RequestParam("postNumber") int postNumber,
                              @RequestParam("resumeId") String resume_number,
                              @RequestParam("resumetitle") String resumeTitle,
                              @RequestParam("number")String number,
                              HttpSession session) {
        JobPost jobPost = jobPostService.getPostDetail(postNumber);
     
        Resume resumes=resumeService.getResumeNumber(number);
        String id=(String) session.getAttribute("id");
        
        applyService.applyForJob(id,resume_number, resumeTitle, postNumber, 
                                 jobPost.getCompanyName(), jobPost.getWorkLocation(), 
                                 jobPost.getSalary(), jobPost.getWorkHours(), 
                                 jobPost.getWorkDays(), jobPost.getJobDescription(),
                                 resumes.getName() , resumes.getContact(), 
                                 resumes.getEmail() ,resumes.getAddress(),resumes.getMyimgName());
        return "redirect:/myApplications";
        
    }
    
    // 지원한 목록 조회 + 지원자가 채용 결과 조회
    @GetMapping("/myApplications")
    public String myApplications(Model model,HttpSession session) {
    	String id=(String) session.getAttribute("id");
    	List<Apply> applications =applyService.getAllapplys(id);
    	model.addAttribute("applications",applications);
    	return "applyreadAll";
    }
    
    // 지원 내역 삭제
    @RequestMapping(value ="/applydelete")
    public String applydelete(@RequestParam("apply_id")String apply_id) {
    	applyService.setDeleteApply(apply_id);
    	return "redirect:/myApplications";
    }
    
    // 기업 지원 내역 조회  + 채용 수락 / 거절 
    @GetMapping("/businesApplylist")
    public String businesApplylist(@RequestParam("postNumber")int postNumber,
    								Model model) {
    	List<Apply> businesapply=applyService.getAllbusinesapplys(postNumber);
    	model.addAttribute("businesapply",businesapply);
    	model.addAttribute("postNumber",postNumber);
    	return "businesApplylist";
	}
    
	@GetMapping("/businesapplyview")
	public String businesapplyview
	(
			@RequestParam("postNumber") int postNumber,
			@RequestParam("apply_id") int apply_id,
			@RequestParam("id") String id,
			Model model
	)
	{
		List<Apply> businesview=applyService.getbusinesview(postNumber,apply_id);
		model.addAttribute("businesview",businesview);
		model.addAttribute("postNumber",postNumber);
		model.addAttribute("id",id); //Apply데이터베이스의 아이디를 가져감
		return "businesapplyview";
	}
	
	//지원자 상태 경 메서드
	@GetMapping("/updateStatus")
	public String updateApply(@RequestParam("apply_id")int apply_id,
							  @RequestParam("status")String status,
							  @RequestParam("postNumber")int postNumber,
							  Model model)
	{
		model.addAttribute("apply_id",apply_id);
		model.addAttribute("status",status);
		model.addAttribute("postNumber",postNumber);

		applyService.updateApplyStatus(apply_id,status,postNumber);
		
		return "redirect:/businesApplylist";
	}

	//알바생 지원 메뉴 클릭시 지원 목록 조회
//	@GetMapping("/Applyread")
//	public String Applyread(Model model, HttpSession session)
//	{
//		String id = (String)session.getAttribute("id");
//		//지원 목록
//		model.addAttribute("read",applyService.getAllapplys(id));
//		return "Applyread";
//	}
}  