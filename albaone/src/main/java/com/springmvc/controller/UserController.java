package com.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.User;
import com.springmvc.service.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
//	로그인 양식
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

//	로그인 처리
	@PostMapping("/login")
	public String login(@RequestParam String id, @RequestParam String password, Model model, HttpSession session) {
		System.out.println("로그인");
		if(userService.loginUser(id, password)) {
			session.setAttribute("id", id);
			return "redirect:/home";
		} else {
			model.addAttribute("error", "로그인 실패");
			return "login";
		}
	}
	
//	회원 정보 수정
	@GetMapping("/update")
	public String editUserForm(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		String BusinessNumber = userService.findBusinessNumber(id);
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		if(BusinessNumber==null) {
			return "registerPersonal";
		} else {
			return "registerBusiness";
		}
	}
	
//	로그아웃
	@GetMapping("/logout")
	public String logout(@RequestParam String id, HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
	
//	회원 가입 구분
	@GetMapping("/register")
	public String userType() {
		return "register";
	}
	
//	개인 회원 양식
	@GetMapping("/register/personal")
	public String personalUserForm() {
		return "registerPersonal";
	}
	
//	기업 회원 양식
	@GetMapping("/register/business")
	public String businessUserForm() {
		return "registerBusiness";
	}
	
//	회원 데이터 생성
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user, BindingResult result) {
		userService.setNewUser(user);
		return "redirect:/login";
	}
	
//	아이디 중복 검사
	@PostMapping("/register/idcheck.do")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String userId) {
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		count = userService.idcheck(userId);
		map.put("cnt", count);
		return map;
	}
	
}
