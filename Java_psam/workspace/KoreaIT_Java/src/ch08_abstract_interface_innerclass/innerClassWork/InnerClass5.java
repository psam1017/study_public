package ch08_abstract_interface_innerclass.innerClassWork;

public class InnerClass5 {
	public static void main(String[] args) {
		
		OuterClass5.InStaticClass sInClass = new OuterClass5.InStaticClass();
		System.out.println("정적 내부 클래스 일반 메소드 호출");
		sInClass.inTest();
		
		System.out.println("정적 내부 클래스 스태틱 메소드 호출");
		OuterClass5.InStaticClass.sInTest();
	}
}

class OuterClass5{
	
	@SuppressWarnings("unused")
	private int num = 10;
	private static int sNum = 20;
	
	static class InStaticClass{
		
		int inNum = 100;
		static int sInNum = 200;
		
		// static class에서는 외부 클래스의 인스턴스 멤버를 사용할 수 없음.
		void inTest() {
			System.out.println(sNum);
			System.out.println(inNum);
			System.out.println(sInNum);
		}
		
		static void sInTest() {
			System.out.println(sNum);
//			System.out.println(inNum); // static 변수만 사용 가능.
			System.out.println(sInNum);
		}
		
	}
}