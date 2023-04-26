package ch07_inheritance;

public class Polymorphism6 {
	public static void main(String[] args) {
		
		// 현실적으로 이렇게 충돌할 일은 거의 없긴 하지만...필드 변수는 부모의 그것을 가져온다.
		// 메소드는 오버라이딩된 자식의 메소드를 사용한다.
		Pa pa = new Ch();
		System.out.println(pa.x);
		pa.method();
	}
}

class Pa{
	int x = 100;
	
	void method() {
		System.out.println("부모의 메소드 우선");
	}
}

class Ch extends Pa{
	int x = 200;

	@Override
	void method() {
		System.out.println("오버라이드된 자식의 메소드 우선");
	}
}