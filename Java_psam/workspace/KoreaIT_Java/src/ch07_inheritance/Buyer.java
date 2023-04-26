package ch07_inheritance;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	
	void buy(Product p) {
		
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price;
		this.bonusPoint += p.bonusPoint;
		System.out.println(p + "을/를 구입하였습니다.");
	}
}
