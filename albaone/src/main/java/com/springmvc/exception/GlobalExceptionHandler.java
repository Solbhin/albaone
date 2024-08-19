package com.springmvc.exception;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
//	SQL 예외 처리
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(SQLException ex, Model model) {
		ModelAndView modelAndView = new ModelAndView("errorPage");
		modelAndView.addObject("message", "데이터베이스 오류가 발생했습니다:" + ex.getMessage());
		return modelAndView;
	}
	
//	전역 예외 처리
	@ExceptionHandler(Exception.class)
	public ModelAndView handleSQLException(Exception ex, Model model) {
		ModelAndView modelAndView = new ModelAndView("errorPage");
		modelAndView.addObject("message", "오류가 발생했습니다:" + ex.getMessage());
		return modelAndView;
	}
	
}
