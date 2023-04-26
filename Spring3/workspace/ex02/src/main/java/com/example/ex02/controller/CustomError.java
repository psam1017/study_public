package com.example.ex02.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomError {
	
	// web.xml에서 404, 405, 500 에러는 "/error" 경로로 가기 때문에 아래 메소드에 도달하게 된다.
	@GetMapping("/error")
	public String goErrorPage(HttpServletRequest req) {
		
		Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null) {
			int statusCode = Integer.valueOf(status.toString());
			
			// HttpStatus.NOT_FOUND -> 404 오류 상태
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				return "/error/404";
			}
		}
		
		return "/error/500";
	}
}
