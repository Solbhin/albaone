package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.employmentcontract;
import com.springmvc.service.ApplyServiceImpl;
import com.springmvc.service.employmentcontractServiceImpl;
import com.springmvc.service.EmployeeServiceImpl;

@Controller
public class employmentcontractController {
	@Autowired
	private employmentcontractServiceImpl employmentcontractService;

	@Autowired
	private ApplyServiceImpl applyService;

	@Autowired
	private EmployeeServiceImpl employeeService;

	// get 요청 발생시 계약서 create 폼 제공
	@GetMapping("/employmentcontract")
	public String employmentcontractform(@RequestParam("apply_id") int apply_id, @RequestParam("status") String status,
			@RequestParam("postNumber") int postNumber, Model model) {
		model.addAttribute("apply_id", apply_id);
		model.addAttribute("status", status);
		model.addAttribute("postNumber", postNumber);

		return "employmentcontractform";
	}

	// 근로계약서 폼에서 요청 발생시 create
	@PostMapping("/employmentcontract")
	public String employmentcontractend(@ModelAttribute("employment") employmentcontract employmentcontract,
			@RequestParam("apply_id") int apply_id, @RequestParam("status") String status,
			@RequestParam("postNumber") int postNumber, HttpSession session, BindingResult result) {
		System.out.println("applyId" + apply_id);
		System.out.println("상태" + status);
		System.out.println("포스트넘버" + postNumber);
		employmentcontractService.create(employmentcontract);
		applyService.updateApplyStatus(apply_id, status, postNumber);
		String businessNumber = (String) session.getAttribute("businessNumber");
		String id = applyService.getEmpolyeeId(apply_id);
		employeeService.addEmployee(id, businessNumber);

		return "redirect:/businesApplylist?postNumber=" + postNumber;
	}

	// 알바생명으로 모든 계약서 조회
	@GetMapping("/contracts")
	public String getContractsByPartTimeName(HttpSession session, Model model) {

		String id = (String) session.getAttribute("id");
		System.out.println();
		if (id != null && !id.isEmpty()) {
			List<employmentcontract> contracts = employmentcontractService.findAllByPartTimeName(id);
			if (!contracts.isEmpty()) {
				model.addAttribute("contract", contracts);
			} else {
				model.addAttribute("error", "해당 알바생명의 계약서가 존재하지 않습니다.");
			}
		}
		return "employmentcontractlistcompany"; // 뷰 이름
	}

	// 사장 이름으로 모든 계약서 조회
	@GetMapping("/bussinesscontracts")
	public String getContractsByPartTimeNameownername(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		if (id != null && !id.isEmpty()) {
			List<employmentcontract> contracts = employmentcontractService.findAllByPartTimeNameownername(id);
			if (!contracts.isEmpty()) {
				model.addAttribute("contracts", contracts);
			} else {
				model.addAttribute("error", "해당 사장 이름의 계약서가 존재하지 않습니다");
			}
		}
		return "employmentcontractlistcompany"; // 뷰 이름
	}

	// 계약서 삭제후 사장 이름으로 이동
	@GetMapping("/empcomdel")
	public String delete(Model model, @RequestParam int num, HttpSession session) {
		System.out.println(num);
		employmentcontractService.deleteContractsByPartTimeName(num);
		// getContractsByPartTimeNameownername 메서드로 이동 - 사장 이름으로 조회
		return "redirect:/bussinesscontracts";
	}
}
