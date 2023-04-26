package com.example.ex02.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex02.domain.vo.InfoDTO;

import lombok.extern.log4j.Log4j;

// @RequestMapping("/ex/*") -> root경로/ex/하위 경로의 모든 요청은 이 컨트롤러가 받는다.
@Controller
@RequestMapping("/ex/*")
@Log4j
public class SampleController {

	// '/'는 앞에 붙여도 되고, 안 붙여도 된다.
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basic(HttpServletRequest req) {
		log.info("basic executed!");
		log.info(req.getMethod());
	}
	
	// @RequestMapping만 선언하는 경우 -> 부모 경로인 .../ex/ 경로에서 호출된다.
	// ".../ex" 후에 '/'까지 입력해야지 호출된다.
	@RequestMapping
	public void basic2() {
		log.info("basic2 executed!");
	}
	
	// get으로 요청했을 때만 호출된다.
	@GetMapping("/basicOnlyGet")
	public void basic3() {
		log.info("basic3 only get");
	}
	
	// request.getParameter로 직접 받지 않아도 된다.
	// InfoDTO를 Spring에게 맡겼기 때문.
	// 하지만 아래처럼 하면 name 필드가 여러 개일때 어느 객체의 필드인지 구분하기 어려울 것이다.
	/*
	@GetMapping("/ex01")
	public void ex01(String name, int age) {
		log.info(name + ", " + age);
	}
	*/
	
	// 따라서 다음과 같이 객체를 선언하여 객체를 받도록 한다.
	// 외부에서 전달된 파라미터를 매개변수 필드명과 자동으로 매핑한다.
	@GetMapping("/ex01")
	public void ex01(InfoDTO info) {
		log.info(info.getName() + ", " + info.getAge());
	}
	
	
	// form에서 name과 age로 보내지 않고 data1, data2라고 이상한 이름으로 데이터를 보내온 경우
	// return 타입이 void인 경우 Mapping으로 받은 경로를 그대로 전달한다.
	// 아래의 경우 ".../ex/ex02.jsp"를 찾게 된다.
	@GetMapping("ex02") // 외부에서 전달된 파라미터의 이름과 매개변수가 다를 경우 @RequestParam을 사용하여 어디로 전달받을지 알려준다.
	public void ex02(@RequestParam("data1") String name, @RequestParam("data2") int age) {
		log.info(name + ", " + age);
	}
	
	// patameter가 여러 개 전달될 때 -> 배열이나 리스트에 자동으로 담기
	// return 타입을 String으로 하면 내가 원하는 경로로 보낼 수 있다.
	@GetMapping("/ex03")
	public String ex03(@RequestParam("data") ArrayList<String> datas) {
		
		log.info("datas : " + datas);
		return "ex03";
	}
	
	// 화면으로 데이터를 전달
	// 만약 매개변수가 객체라면, 해당 클래스 타입의 앞글자만 소문자로 변경된 값이 화면에서 사용할 key 값이다.
	// ex. 매개변수 타입이 InfoDTO라면, 화면에서 사용할 key값은 infoDTO가 된다.
	// 만약 key 값을 수정하거나 매개변수가 많아진다면, 직접 requestScope에 담아서 전달해야 한다.
	// 이때 request 객체를 직접 불러오진 않고, Model이라는 데이터 전달자를 사용하게 된다.
	// 하지만 화면 쪽에 전달할 데이터가 여러 개가 아니라면, @ModelAttribute()를 사용하여 화면에 전달해준다.
	// 왜냐하면... 전달할 데이터가 여러 개일 때 매번 annotation을 쓰면 너무 길어지니까!
	// @ModelAttribute("화면에 사용할 Key")
	@GetMapping("ex04")
	public String ex04(InfoDTO infoDTO, @ModelAttribute("info") InfoDTO info) {
		log.info("===================================");
		log.info("ex04");
		log.info(infoDTO.toString());
		log.info("===================================");
		
		return "ex04";
	}
	
	@RequestMapping("ex05") // RequestMapping의 기본 Method는 GET 방식이다.
	public void ex05(InfoDTO info, @ModelAttribute("gender") String gender, HttpServletRequest req) {
		log.info("ex05 executed");
		log.info(req.getMethod());
		log.info(info.toString());
		log.info("gender : " + gender);
	}
	
	// Model 객체 사용해보기
	// Model 객체는 파라미터로 request 객체를 받는다.
	// 따라서 여러 개의 데이터를 화면에 전달할 때
	// addAttribute(KEY, VALUE)를 사용한다.
	// 화면에서는 Model에서 설정한 KEY로 VALUE를 사용할 수 있다.
	@GetMapping("ex06")
	public String ex06(InfoDTO info, String gender, Model model) {
		
		// "사용할 key 이름", 객체 타입
		model.addAttribute("gender", gender);
		model.addAttribute("info", info);
		
		log.info("ex06 executed");
		log.info(info.toString());
		log.info("gender : " + gender);
		
		return "ex/ex06";
	}
	
	
}












