package com.springmvc.controller;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.springmvc.domain.Employmentcontract;
import com.springmvc.service.*;

@Controller
public class EmploymentcontractController {
	@Autowired
	private EmploymentcontractServiceImpl employmentcontractService;

	@Autowired
	private ApplyServiceImpl applyService;

	@Autowired
	private UserServiceImpl UserServiceImpl;
	
	@Autowired
	private EmployeeServiceImpl employeeService;

	// get 요청 발생시 계약서 create 폼 제공
	@GetMapping("/employmentcontract")
	public String employmentcontractform
	(
			@RequestParam("apply_id") int apply_id, @RequestParam("status") String status,
			@RequestParam("postNumber") int postNumber, @RequestParam("parttimename") String parttimename,
			@RequestParam("parttimephone") String parttimephone,
			@RequestParam("parttimeaddress") String parttimeaddress,
			@RequestParam("id") String employeeId,
			@RequestParam("parttimeid") String parttimeid,
			Model model,
			HttpSession session
	)
	{

		String id = (String) session.getAttribute("id");
		System.out.println("직원 ID: "+employeeId);
		
		model.addAttribute("apply_id", apply_id);
		model.addAttribute("status", status);
		model.addAttribute("postNumber", postNumber);
		model.addAttribute("user", UserServiceImpl.findUserById(id));
		model.addAttribute("BusinessNumber", UserServiceImpl.findBusinessNumber(id));
		model.addAttribute("employeeId", employeeId);
		model.addAttribute("parttimeid",parttimeid); //알바생 id
		if (parttimename != null) {
			model.addAttribute("parttimename", parttimename);
		}
		if (parttimephone != null) {
			model.addAttribute("parttimephone", parttimephone);
		}
		if (parttimeaddress != null) {
			model.addAttribute("parttimeaddress", parttimeaddress);
		}

		return "employmentcontractform";
	}

	// 근로계약서 폼에서 요청 발생시 create
	@PostMapping("/employmentcontract")
	public String employmentcontractend(@ModelAttribute("employment") Employmentcontract employmentcontract,
			@RequestParam("apply_id") int apply_id, @RequestParam("status") String status,
			@RequestParam("postNumber") int postNumber,
			@RequestParam(value = "insurance", required = false) List<String> insurance,
			@RequestParam("workinghours_start") String workingHoursStart,
			@RequestParam("workinghours_end") String workingHoursEnd,
			@RequestParam(value = "workday", required = false) String workday,
			@RequestParam("employeeId") String employeeId, BindingResult result,
			HttpServletRequest req, HttpSession session) {
		if (result.hasErrors()) {
			return "resume";
		}
		
		String businessNumber = employmentcontract.getBusinessNumber();
		String root = req.getServletContext().getRealPath("/resources/images");// 저장 경로
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String day = employmentcontract.getPeriod_start();
		LocalDate date = LocalDate.parse(day, formatter);
		
		System.out.println("Post 직원 ID: "+employeeId);
		
		// sineName - 파일명, 파라미터
		MultipartFile sineNameowner = employmentcontract.getSinefileowner();// 멀티 파츠로 파일 생성
		MultipartFile sineNameparttime = employmentcontract.getSinefileparttime();
		System.out.println(sineNameowner);
		System.out.println(sineNameparttime);

		String saveNameowner = sineNameowner.getOriginalFilename();// 원래 파일명
		String saveNameparttime = sineNameparttime.getOriginalFilename();

		File saveFileowner = new File(root, saveNameowner);
		File saveFileparttime = new File(root, saveNameparttime);

		if (sineNameowner != null && !sineNameowner.isEmpty())
			try {
				sineNameowner.transferTo(saveFileowner);
				employmentcontract.setSinefilenameowner(saveNameowner);
			} catch (Exception e) {
				e.printStackTrace();
			}

		if (sineNameparttime != null && !sineNameparttime.isEmpty())
			try {
				sineNameparttime.transferTo(saveFileparttime);
				employmentcontract.setSinefilenameparttime(saveNameparttime);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 체크박스로 받은 보험 항목을 문자열로 변환하여 employmentcontract에 설정
		if (insurance != null && !insurance.isEmpty()) {
			// 리스트를 문자열로 변환
			String insuranceString = String.join(", ", insurance);
			employmentcontract.setInsurance(insuranceString);
		}

		// 리스트의 ,제거 - select로 넘어올 경우의 ,제거
		workingHoursStart = workingHoursStart.replace(",", "").trim();
		workingHoursEnd = workingHoursEnd.replace(",", "").trim();

		employmentcontract.setWorkinghours_start(workingHoursStart);
		employmentcontract.setWorkinghours_end(workingHoursEnd);

		// 체크박스로 받은 근로날짜 항목을 문자열로 변환하여 employmentcontract에 설정
		if (workday != null && !workday.isEmpty()) {
			// 리스트를 문자열로 변환
			String workdayString = String.join(", ", workday);
			employmentcontract.setWorkday(workdayString);
		}
		
		employmentcontractService.create(employmentcontract);
		applyService.updateApplyStatus(apply_id, status, postNumber);
		employeeService.addEmployee(businessNumber, employeeId, date);
		
		return "redirect:/businesApplylist?postNumber=" + postNumber;
	}

	// 사업자 번호로 계약서 조회
	@GetMapping("/contracts")
	public String getContractsByPartTimeName(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		String BusinessNumber = UserServiceImpl.findBusinessNumber(id);
		if (BusinessNumber != null && !BusinessNumber.isEmpty()) {
			List<Employmentcontract> contracts = employmentcontractService.findAllByBusinessNumber(BusinessNumber);
			if (!contracts.isEmpty()) {
				model.addAttribute("contract", contracts);
			} else {
				model.addAttribute("error", "해당 알바생명의 계약서가 존재하지 않습니다.");
			}
		}
		return "employmentcontractlistcompany"; // 뷰 이름
	}

	// 계약서 삭제
	@GetMapping("/empcomdel")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam int num, HttpSession session)
	{
	    employmentcontractService.deleteContractsByPartTimeName(num);

	    // 헤더 설정
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));

	    return new ResponseEntity<>("삭제되었습니다.", headers, HttpStatus.OK); // 성공 메시지 반환
	}

	// 다운로드 샘플 보여주기
	@GetMapping("/downloadcontractexam")
	public String downloadcontractexam(Model model, @RequestParam("num") int num) {
		model.addAttribute("contract", employmentcontractService.findByNum(num));
		return "downloadcontractexam";
	}
	
	//알바생 계약서 조회 - 사장 조회와 동일, 사업자번호로 조회하냐, 아이디로 조회하냐
	@GetMapping("contractsParttime")
	public String contractsParttime(HttpSession session, Model model)
	{
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		List<Employmentcontract> contracts = employmentcontractService.findAllByParttimeid(id);
		model.addAttribute("id",id);
		if (!contracts.isEmpty())
		{
			System.out.println("실행됨");
			model.addAttribute("contract", contracts);
		}
		else
		{
			System.out.println("실행안됨");
			model.addAttribute("error", "해당 알바생명의 계약서가 존재하지 않습니다.");
		}
		
		return "employmentcontractlist";
	}
}
