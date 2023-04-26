package ch07_inheritance.PolymorphismWork1;

import java.util.ArrayList;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	
	ArrayList<Product> item = new ArrayList<Product>();
	
	void buy(Product p) {
		
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price;
		this.bonusPoint += p.bonusPoint;
		item.add(p);
		System.out.println(p + "을/를 구입하였습니다.");
	}
	
	void refund(Product p) {
		if(item.remove(p)) {
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/을 반품하였습니다.");
		}
		else
			System.out.println("구입한 제품 중" + p + "은/는 없습니다.");
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		
		if(item.isEmpty()) {
			System.out.println("구입한 제품이 없습니다.");
			return;
		}
		
		// Product의 길이는 10으로 고정되어 있지만, Buyer가 구매한 제품의 개수는 10이 아닐 수 있다.
		for(int i = 0; i < item.size(); i++) {
			Product p = (Product)item.get(i);
			sum += p.price;
			itemList += (i == 0) ? "" + p : ", " + p;  
		}
		
		System.out.println("구입한 제품의 총 금액 : " + sum);
		System.out.println("구입하여 얻은 적립액 : " + this.bonusPoint);
		System.out.println("구입한 제품 품목 : " + itemList);
	}
}
