package com.example.ex02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

// AOP(관점 지향 프로그래밍)
// ExceptionHandler
// 예외처리의 주도권을 가져오기

// CustomError.java 테스트를 위해 전부 주석처리함.
@SuppressWarnings("unused")
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	/*
	@ExceptionHandler(Exception.class)
	public String except500(Exception e, Model model) {
		
		log.error(e.getMessage());
		model.addAttribute("exception", e);
		log.error(model.toString());
		
		// 에러 발생 시 이동할 파일 이름을 아래와 같이 에러 코드인 숫자로 사용하기를 권장하고 있다.
		return "error/500";
	}
	
	// 404 에러는 예외를 발생시키지 않고, 404 페이지를 보여준다.
	// 404 에러에서 예외 stack을 보고자 할 때는 web.xml을 다음과 같이 변경해야 한다.
	/*
	/*
	<servlet> 태그 안에서 아래와 같이 선언
	
	<init-param>
		<param-name>throwExceptionIfNoHandlerFound</param-name>
		<param-value>true</param-value>
	</init-param>
	*/
	/*
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String except404(NoHandlerFoundException e) {
		return "/error/404";
	}
	
	// 여기까지만 해버리면, root 경로 아래에 또 다른 컨트롤러 안에 들어가서 404 예외가 발생했을 때 default 404 페이지가 떠버린다.
	// 모든 컨트롤러에 대하여 예외 페이지를 적용하고자 할 때는
	// web.xml에서 servlet 태그 안에서 선언했던 내용은 삭제하고
	// AOP 개념을 활용하여 web.xml에서 횡단 관심사를 분리해서 적용해야 한다.
	// 모든 404 예외 발생 시 내가 만든 페이지로 갈 수 있도록.
	
	*/
}
