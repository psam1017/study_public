package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex02.domain.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MemberController {
	
	// 아이디와 비밀번호를 입력받은 후
	// 아이디가 admin인 경우 admin.jsp로 이동
	// 아이디가 user인 경우 user.jsp로 이동
	@RequestMapping("/member")
	public String signIn(@ModelAttribute("member") MemberVO member) {
		
		log.info(member.getId());
		log.info(member.getPw());
		
		if(member.getId().equals(member.getPw())) {
			if(member.getId().equals("admin")) {
				log.info("관리자 로그인");
				return "/task01/admin";
			}
			else {
				log.info("회원 로그인");
				return "/task01/user";
			}
		}
		else {
			log.info("로그인 실패");
			return "/task01/loginFail";
		}
	}
}
