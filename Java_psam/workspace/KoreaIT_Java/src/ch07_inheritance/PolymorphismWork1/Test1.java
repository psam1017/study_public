package ch07_inheritance.PolymorphismWork1;

public class Test1 {
	public static void main(String[] args) {
		
		Buyer b = new Buyer();
		TV t = new TV();
		Computer c = new Computer();
		Audio a = new Audio();
		
		b.buy(t);
		b.buy(c);
		b.buy(a);
		b.summary();
		
		System.out.println();
		b.refund(c);
		b.summary();
		
	}
}
