package com.springmvc.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Employmentcontract;
import com.springmvc.domain.Severance;
import com.springmvc.repository.EmploymentcontractRepositoryImpl;
import com.springmvc.service.SeveranceServiceImpl;

@Controller
public class SeveranceController {
	// 퇴직금 계산을 위해 계약서 연결
	@Autowired
	private EmploymentcontractRepositoryImpl employmentcontractService;

	@Autowired
	private SeveranceServiceImpl SeveranceService;

	// 퇴직금 지급 - 알바생명 입력
	@GetMapping("/Severance")
	public String Severancecreate() {
		System.out.println("퇴직금 지급 메서드");
		return "Severance";
	}

	// 퇴직금 폼
	@PostMapping("/Severance")
	public String Severanceform(@RequestParam(value = "partname") String parttimename, Model model) {
		System.out.println("퇴직금 계산 메서드");

		if (parttimename != null && !parttimename.isEmpty()) {
			List<Employmentcontract> contracts = employmentcontractService.findAllByBusinessNumber(parttimename);

			if (!contracts.isEmpty()) {
				// 첫 번째 계약서의 정보 가져오기
				Employmentcontract inputContract = contracts.get(0);

				// 알바생명, 금액, 시작일, 종료일 변수에 담기
				String retrievedPartTimeName = inputContract.getParttimename();
				long money = inputContract.getMoney();
				long bonus = inputContract.getBonus();
				String periodStart = inputContract.getPeriod_start();
				String periodEnd = inputContract.getPeriod_end();

				// 모델에 추가
				model.addAttribute("parttimename", retrievedPartTimeName);
				model.addAttribute("money", money);
				model.addAttribute("bonus", bonus);
				model.addAttribute("periodStart", periodStart);
				model.addAttribute("periodEnd", periodEnd);
			} else {
				model.addAttribute("error", "해당 알바생명의 계약서가 존재하지 않습니다.");
			}
		}

		return "Severanceform";
	}

	// 퇴직금 계산 및 DB에 저장
	@PostMapping("/SeveranceCal")
	public String SeveranceCal(@RequestParam(value = "partname") String partname,
			@RequestParam(value = "money") String money, @RequestParam(value = "bonus") String bonus,
			@RequestParam(value = "start") String start, @RequestParam(value = "day") String day, Model model) {
		long totalmoney = 0;
		long mymoney = Long.parseLong(money);
		long bonusAmount = Integer.parseInt(bonus);

		// 날짜 형식 변환 및 차이 계산
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(start, formatter);
		LocalDate endDate = LocalDate.parse(day, formatter);

		// 입사와 퇴사 차이 구하기
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		// 근속 일수/365일
		double yearsBetween = daysBetween / 365.0;

		// 퇴직금 계산하기 (임금*3 + 보너스) * 30일 * (근속일수 /365일)
		totalmoney = (long) ((mymoney * 3 + bonusAmount) * 30 * yearsBetween);

		model.addAttribute("money", totalmoney);

		// 묶음 처리
		Severance Severance = new Severance();
		Severance.setParttimename(partname);
		// 나중에 실제 회사명을 받아옴
		Severance.setCompany("회사명");
		Severance.setMoney(totalmoney);

		// 퇴직금 저장 - 리파지토리
		SeveranceService.create(Severance);

		return "SeveranceCalView";
	}

	// 퇴직금 조회
	@GetMapping("/SeveranceRead")
	public String SeveranceRead(HttpSession session, Model model) {
		// 알바생아이디를 세션에서 가져옴
		String id = (String) session.getAttribute("id");
		// 회사명 변수 - 본인 회사를 변수에 넣어야됨
		String businessNumber = (String) session.getAttribute("businessNumber");
		System.out.println(id);
		System.out.println(businessNumber);
		// 알바생은 read 제공
		List<Severance> SeveranceServices_alba = SeveranceService.findAllBySeverance_alba(id);
		model.addAttribute("severanceList_alba", SeveranceServices_alba);
		// 회사명으로 퇴직금 조회
		List<Severance> SeveranceServices_com = SeveranceService.findAllBySeverance_comp(businessNumber);
		model.addAttribute("severanceList_com", SeveranceServices_com);
		return "SeveranceRead";
	}
}
