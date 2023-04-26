package ch08_abstract_interface_innerclass.innerClassWork;

public class InnerClass4 {
	public static void main(String[] args) {
		
		OuterClass4 oc41 = new OuterClass4();
		oc41.outTest();
		
		System.out.println();
		
		// OuterClass4.InClass in1 = oc41.new InClass();
		OuterClass4.InClass in1 = new OuterClass4().new InClass();
		in1.inTest();
		OuterClass4.InClass.sTest();
		System.out.println(OuterClass4.InClass.inSNum); // 객체 생성 없이 내부 클래스의 스태틱 멤버를 호출
		// in1.usingClass(); // 내부 클래스 바깥에 있는 메소드
		
		
	}
}

	// 외부 클래스에서 내부 클래스의 인스턴스 참조변수를 선언.

class OuterClass4{
	
	private int num = 10;
	private static int sNum = 20;
	private InClass inClass;
	
	public OuterClass4() {
		inClass = new InClass();
	}
	
	// 구조 상 인스턴스 생성 없이 static을 만들 수 없지만,
	// 자바 16버전(2021-03)부터는 내부 인스턴스 클래스 안에 static 키워드를 사용할 수 있음.
	class InClass{
		int inNum = 100;
		static int inSNum = 200;
		
		// 내부 인스턴스 클래스의 메소드는 인스턴스 멤버, 클래스 멤버 모두 사용가능하다.
		void inTest() {
			System.out.println(num);
			System.out.println(sNum);
			System.out.println(inNum);
			System.out.println(inSNum);
		}
		
		static void sTest() {
			System.out.println();
		}
	}
	
	public void outTest() {
		inClass.inTest();
	}
}