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
import com.springmvc.service.AttendanceServiceImpl;
import com.springmvc.service.AlbarateServiceImpl;

@Controller
public class UserController
{
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private AttendanceServiceImpl attendanceService;
	
	@Autowired
	private AlbarateServiceImpl AlbarateServiceImpl;

	//로그인 양식
	@GetMapping("/login")
	public String loginForm()
	{
		return "login";
	}

	//로그인 처리
	@PostMapping("/login")
	public String login(@RequestParam String id, @RequestParam String password, Model model, HttpSession session)
	{
		if (userService.loginUser(id, password))
		{
			session.setAttribute("id", id);
			String businessNumber = userService.findBusinessNumber(id);
			User user = userService.findUserById(id);
			String name = user.getName();
			session.setAttribute("name", name);
			session.setAttribute("businessNumber", businessNumber);
			return "redirect:/home";
		}
		else
		{
			model.addAttribute("error", "로그인 실패");
			return "login";
		}
	}

	//회원 정보 수정 양식
	@GetMapping("/update")
	public String updateUserForm(HttpSession session, Model model)
	{
		String id = (String) session.getAttribute("id");
		String BusinessNumber = userService.findBusinessNumber(id);
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		if (BusinessNumber == null)
		{
			return "updatePersonal";
		}
		else
		{
			return "updateBusiness";
		}
	}

	//회원 정보 수정
	@PostMapping("/update")
	public String updateUser(@ModelAttribute("user") User user)
	{
		userService.updateUser(user);
		return "redirect:/home";
	}

	//로그아웃
	@GetMapping("/logout")
	public String logout(@RequestParam String id, HttpSession session)
	{
		session.invalidate();
		return "redirect:/home";
	}


	//회원 가입 구분
	@GetMapping("/register")
	public String userType()
	{
		return "register";
	}


	//개인 회원 양식
	@GetMapping("/register/personal")
	public String personalUserForm()
	{
		return "registerPersonal";
	}


	//기업 회원 양식
	@GetMapping("/register/business")
	public String businessUserForm()
	{
		return "registerBusiness";
	}


	//회원 가입 처리
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user, BindingResult result)
	{
		AlbarateServiceImpl.insert(user.getId());
		userService.setNewUser(user);
		return "redirect:/login";
	}


	//아이디 중복 검사
	@PostMapping("/register/idcheck.do")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String userId)
	{
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		count = userService.idcheck(userId);
		map.put("cnt", count);
		return map;
	}


	//회원 탈퇴 및 근태 기록 삭제
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") String id, HttpSession session)
	{
		attendanceService.deleteAttendance(id);
		userService.deleteUser(id);
		session.invalidate();
		return "redirect:/home";
	}

}
