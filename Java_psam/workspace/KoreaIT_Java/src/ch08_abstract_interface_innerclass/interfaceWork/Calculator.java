package ch08_abstract_interface_innerclass.interfaceWork;

// 추상 클래스는 인터페이스의 모든 추상 메소드를 구현하지 않아도 된다.
public abstract class Calculator implements Calc {

	// 추상 메소드를 구현한 일반 메소드.
	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}
}
