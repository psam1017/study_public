package ch07_inheritance;

public class Leader extends Student{

	@Override
	void sayHi() {

		// super.sayHi(); // 부모 클래스의 기존 메서드를 호출.
		
		System.out.println("선생님께 인사!");
		
	}
}
