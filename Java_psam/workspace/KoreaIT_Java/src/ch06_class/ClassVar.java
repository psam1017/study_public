package ch06_class;

public class ClassVar {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		// 메모리 구조 : 코드 영역, 데이터 영역, 스택 영역, 힙 영역
		// 데이터 영역 : 전역 변수와 정적 변수(static) 저장.
		// 스택 영역 : 지역 변수를 저장.
		// 힙 영역 : 인스턴스와 배열을 저장.
		
		
		
		// 클래스 변수 : 모든 인스턴스가 공통으로 공유하는 변수. (ex) 같은 학교, 아파트 공용 공간
		// -> 처음 메모리에 로딩될 때 생성된다. 따라서 별도의 인스턴스를 생성하지 않아도 사용할 수 있다.
		// -> 클래스 변수에 인스턴스를 통해 접근하는 것은 바람직하진 않다.
		// static 자료형 변수명;
		
		// 인스턴스 변수는 각 인스턴스가 값을 다르게 가지는 변수이다.
		
		Cars myCar1 = new Cars();
		Cars myCar2 = new Cars();
		
		System.out.println("myCar1의 바퀴 : " + myCar1.wheel);
		System.out.println("myCar1의 속도 : " + myCar1.speed);
		System.out.println("myCar2의 바퀴 : " + myCar2.wheel);
		System.out.println("myCar2의 속도 : " + myCar2.speed);

		
		
		// 인스턴스를 통해서 클래스 변수와 인스턴스를 변경
		myCar1.wheel = 6;
		myCar1.speed = 40;
				
		System.out.println("myCar1의 바퀴 : " + myCar1.wheel);
		System.out.println("myCar1의 속도 : " + myCar1.speed);
		System.out.println("myCar2의 바퀴 : " + myCar2.wheel);
		System.out.println("myCar2의 속도 : " + myCar2.speed);
	}
}

class Cars{
	static int wheel = 4;
	int speed;
}