package com.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.springmvc.domain.Albarate;
import com.springmvc.service.AlbarateServiceImpl;

@Controller
public class rateController {
	@Autowired
	private AlbarateServiceImpl AlbarateServiceImpl;

	// 알바등급 폼 제공 - 사장 전용
	@GetMapping("/writeAlbarate")
	public String Albarateform() {
		return "Albarateform";
	}

	// 등급 조정 - 사장 평가
	@PostMapping("/writeAlbarate")
	public String Albarate(@ModelAttribute("Albarate") Albarate albarate, Model model) {
		System.out.println(albarate.getRating());

		if ("positive".equals(albarate.getRating())) {

			albarate.setCompany(1); // 사장 평가 +1
		} else if ("negative".equals(albarate.getRating())) {
			albarate.setCompany(-1); // 사장 평가 -1
		}
		// 리파지토리
		AlbarateServiceImpl.update(albarate);
		return "Albarateform";
	}

	// 등급 조회
	@GetMapping("/ReadAlbarate")
	public String ReadAlbarate(HttpSession session, Model model) {
		// 알바생아이디를 세션에서 가져옴
		// 세션쪽 확인
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		// 근태값 - 몇번찍었는지
		// 얼마나 깜빡했는지와 결근 출퇴근을 업데이트 - attendance에서 가져와야 함
		// attendace에서 깜빡했는지 체크하기 위한 열을 하나 더 만든다.
		// attandancecontoller에서 사장이 수정을 하게 될 경우 갱신 발생
		// AlbarateServiceImpl.update(null);
		model.addAttribute("read", AlbarateServiceImpl.read(id));
		return "ReadAlbarate";
	}
}
