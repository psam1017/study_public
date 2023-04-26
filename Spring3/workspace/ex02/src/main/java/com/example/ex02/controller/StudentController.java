package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex02.domain.vo.StudentVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/student/*")
@Log4j
public class StudentController {

	// 외부에서 학생의 번호, 국영수 점수를 모델 객체에 받고, 전달한다.
	// 전달 받은 파라미터(form)와, model 객체의 필드(mvc)가 일치한다면 자동으로 맵핑된다.
	// 리턴 시 알맞는 페이지로 이동하고, 모델 객체는 직접 KEY를 지정하지 않아도
	// 화면에서는 앞글자만 소문자로 바뀐 값으로 해당 필드에 접근할 수 있다.
	@RequestMapping("/score")
	public String getScore(@ModelAttribute("student") StudentVO student) {
		
		log.info("student 객체 사용");
		log.info(student.toString());
		return "ex/student";
	}
}
