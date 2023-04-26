package ch07_inheritance;

public class Computer extends Product {
	
	// Computer 클래스의 가격은 200만 원으로 고정.
	Computer(){
		super(200);
	}

	@Override
	public String toString() {
		return "Computer";
	}
}
