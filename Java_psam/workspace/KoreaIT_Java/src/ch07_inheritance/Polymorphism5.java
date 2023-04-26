package ch07_inheritance;

public class Polymorphism5 {

	// Product <- TV, Product <- Computer
	public static void main(String[] args) {
		
		Buyer b = new Buyer();
		TV tv = new TV();
		Computer com = new Computer();
		
		b.buy(tv);
		b.buy(com);
		
		System.out.println("현재 남은 돈 : " + b.money);
		System.out.println("현재 적립액 : " + b.bonusPoint);
		
	}

}
