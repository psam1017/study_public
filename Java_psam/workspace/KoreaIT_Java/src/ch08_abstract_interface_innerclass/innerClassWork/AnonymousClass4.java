package ch08_abstract_interface_innerclass.innerClassWork;

public class AnonymousClass4 {
	public static void main(String[] args) {
		
		Anony4 a4 = new Anony4();
		a4.method(10, 20);
	}
}

interface Calc{
	public int sum();
}

class Anony4{
	private int field;
	
	public void method(final int arg1, int arg2) {
		final int var1 = 0;
		int var2 = 0;
		
		field = 10;
		
		// 아래의 4줄은 에러가 발생한다.
		// arg1 = 10; // 매개변수가 상수
		// arg2 = 20; // 내부 익명 클래스에서 사용하므로 상수화됨.
		// var1 = 30; // 지역변수가 상수
		// var2 = 40; // 내부 익명 클래스에서 사용하므로 상수화됨. 초기화는 가능
		
		Calc calc = new Calc() {
			
			@Override
			public int sum() {
				int result = field + arg1 + arg2 + var1 + var2;
				return result;
			}
		};
		System.out.println(calc.sum());
	}
}
