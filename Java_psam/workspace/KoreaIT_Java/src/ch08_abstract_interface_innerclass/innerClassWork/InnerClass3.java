package ch08_abstract_interface_innerclass.innerClassWork;

public class InnerClass3 {
	public static void main(String[] args) {
		
		OuterClass oc1 = new OuterClass();
		System.out.println("참조변수 oc1.a(인스턴스 변수) : " + oc1.a);
		System.out.println("클래스 OuterClass.b(스태틱 변수) : " + OuterClass.b);
		
		
		
		System.out.println("\n\n===Inner Class에 접근===");
		OuterClass.Inner ii1 = new OuterClass().new Inner(); // 객체를 생성해야 그 안의 멤버인 내부 클래스에 접근이 가능.
		
		System.out.println("Inner의 인스턴스 변수 ii1.c : " + ii1.c);
		ii1.innerMethod();
		
		
		
		System.out.println("\n\n===Static Inner Class에 접근===");
		OuterClass.StaticInner si1 = new OuterClass.StaticInner(); // 객체 없이도 스태틱 내부 클래스에 접근, 생성이 가능.
		System.out.println("StaticInner의 인스턴스 변수 si1.d : " + si1.d);
		System.out.println("OuterClass.StaticInner.stat : " + OuterClass.StaticInner.stat);
		
//		error msg : The static method should be accessed in a static way
//		si1.staticMethod();
		OuterClass.StaticInner.staticMethod();
		
	}
}

class OuterClass{
	
	int a = 1;
	static int b = 2;
	
	class Inner{
		int c = 3;
		
		public void innerMethod() {
			System.out.println("Inner Class");
		}
	}
	
	static class StaticInner{
		int d = 4;
		static int stat = 10;
		
		public static void staticMethod() {
			System.out.println("Static Inner Class");
		}
	}
}
