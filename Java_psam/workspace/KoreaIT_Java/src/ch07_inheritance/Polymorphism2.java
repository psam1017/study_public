package ch07_inheritance;

public class Polymorphism2 {
	public static void main(String[] args) {
		
		A obj = new B();
		obj.methodA();
//	obj.methodB(); // 에러 발생!
		
		
		
		B obj1 = new B();
		obj1.methodB();
		
		
		
		A obj2 = obj1;
		obj2.methodA();
//	obj2.methodB(); // 에러 발생!
	}
}

class A{
	void methodA() { System.out.println("A 메소드 실행"); }
}

class B extends A{
	void methodB() { System.out.println("B 메소드 실행"); }
}