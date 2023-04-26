package com.example.ex02.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ex02.domain.vo.Product;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ExampleController {
	
	// 1. 출퇴근 관리
	// 2. 바코드 입력
	// 3. 할인률 적용
	// 4. 포인트 제도
	
	// 이름을 입력하고, 출근 또는 퇴근 버튼을 클릭한다.
	// 출근은 09:00, 퇴근은 18:00
	// 출근 버튼 시 9시가 넘으면 지각
	// 퇴근 버튼 클릭 시 18시 전이라면 퇴근이 아닌 "업무시간"으로 처리한다.
	
	// 모든 jsp는 work 경로 안에 생성하며 아래와 같이 분기별로 jsp 문서를 한 개씩 작성한다.
	// getToWork.jsp
	// leaveWork.jsp
	// lateWork.jsp
	// onWork.jsp
	
	@RequestMapping("/checkIn")
	public String checkIn() {
		log.info("근태 관리 페이지 호출!");
		return "work/checkIn";
	}
	
	@RequestMapping("/getToWork")
	public String getToWork(@ModelAttribute("name") String name) {
		log.info("출근 신호 들어옴");
		
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);

		boolean isLate = hour >= 9 && minute > 0;
		return isLate ? "/work/lateWork" : "/work/getToWork" ;
	}
	
	@RequestMapping("/leaveWork")
	public String leaveWork(@ModelAttribute("name") String name) {
		log.info("퇴근 신호 들어옴");
		
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);

		boolean isLeave = hour >= 18 && minute >= 0;
		return isLeave ? "/work/leaveWork" : "/work/onWork" ;
	}
	
	// 상품의 바코드를 입력 받고 해당 상품명을 출력한다.
	// 오징어 땅콩 - 4383927
	// 초코 우유 - 0832147
	// 벌꿀 피자 - 9841631
	// 샌드위치 - 5587578
	
	@RequestMapping("/market")
	public String goMarket() {
		return "market/market";
	}
	
	@RequestMapping(value = "/cashier", method = RequestMethod.POST)
	public String getProduct(String barcode, Model model) {
		
		String productName = null;
		
		switch (barcode) {
		case "4383927":
			productName = "오징어 땅콩";
			break;
		case "0832147":
			productName = "초코 우유";
			break;
		case "9841631":
			productName = "벌꿀 피자";
			break;
		case "5587578":
			productName = "샌드위치";
			break;
		default:
			productName = "존재하지 않는 상품";
			break;
		}
		
		model.addAttribute("productName", productName);
		return "/market/cashier";
	}
	
	// 선택한 할인률을 해당 상품에 적용
	// 버턴을 여러 개 만들어서 클릭된 할인률만큼 상품의 가격에 적용
	// @GetMapping("/sale")
	// saleChange.jsp
	// - 선택, 상품명, 가격 총 3개의 항목으로 구성한다.
	// 각 상품의 선택 부분은 radio 버튼으로 구성한다.
	// 할인률 버튼은 10%, 30%, 60%, 90% 총 4개이다.
	// 마지막에 적용 버튼을 제작하여 form 태그를 전송한다.
	
	// @PostMapping("/change")
	// 상품 모델 객체로 전체 내용을 전달받는다.
	// 전달 받은 상품 가격에 할인률을 적용한 가격을 showChange.jsp로 전달한다.
	
	@GetMapping("/sale")
	public String goChangeSale() {
		return "/product/saleChange";
	}
	
	@PostMapping("/change")
	public String change(Product product, Model model) {
		model.addAttribute("originPrice", product.getProductPrice());
		product.setProductPrice((int)(product.getProductPrice() * (100 - product.getDiscountRate()) / 100.0));
		return "/product/showChange";
	}
	
	@PostMapping("/usePoint")
	public String usePoint(Product product) {
		return "/product/usePoint";
	}
	
	@PostMapping("/use")
	public String use(Product product, Integer point, Model model) {
		
		int cash = product.getProductPrice() - point;
		if(point >= product.getProductPrice()) {
			point = product.getProductPrice();
			cash = 0;
		}
		model.addAttribute("product", product);
		model.addAttribute("point", point);
		model.addAttribute("cash", cash);
		
		return "/product/bill";
	}
}
