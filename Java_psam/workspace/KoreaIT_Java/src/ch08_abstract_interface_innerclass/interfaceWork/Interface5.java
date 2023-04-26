package ch08_abstract_interface_innerclass.interfaceWork;

public class Interface5 {
	public static void main(String[] args) {
		
		// 인터페이스 업캐스팅(자동 형변환)
		Customer customer = new Customer();
		Buy buyer = customer;
		Sell seller = new Customer();
		
		buyer.buy();
		seller.sell();
		System.out.println();
		
		
		
		// 인터페이스 다운캐스팅(명시적 형변환)
		if(seller instanceof Customer) {
			Customer newCustomer = (Customer)seller; // Sell 타입을 Customer 타입으로 형변환
			newCustomer.deal();
			newCustomer.order();
		}
	}
}

interface Buy{
	void buy();
	void deal();
	
	default void order() {
		System.out.println("주문 구매");
	}
}

interface Sell{
	void sell();
	void deal();
	
	default void order() {
		System.out.println("주문 판매");
	}
}

class Buyer implements Buy{

	@Override
	public void buy() {
		System.out.println("구매하기");
	}

	@Override
	public void deal() {
		System.out.println("판매자가 흥정하기");
	}
}

class Seller implements Sell{

	@Override
	public void sell() {
		System.out.println("판매하기");
	}

	@Override
	public void deal() {
		System.out.println("구매자가 흥정하기");
	}
}

// deal() : 같은 이름의 추상 메소드를 상속받았기에 오류가 발생하지 않음.
// order() : 같은 이름의 디폴트 메소드가 각각 다른 인터페이스에서 구현되었기 때문에 구체적인 오버라이딩이 필요함.
class Customer implements Buy, Sell{

	@Override
	public void sell() {
		System.out.println("판매하기");
	}

	@Override
	public void buy() {
		System.out.println("구매하기");
	}

	@Override
	public void deal() {
		System.out.println("고객이 흥정하기");
	}
	
	@Override
	public void order() {
		System.out.println("고객 판매 주문");
	}
}