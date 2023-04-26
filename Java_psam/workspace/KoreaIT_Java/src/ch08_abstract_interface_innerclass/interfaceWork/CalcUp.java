package ch08_abstract_interface_innerclass.interfaceWork;

public interface CalcUp {
	
	// public static final이 생략됨.
	double PI = 3.14;
	int ERROR = -999999999;
	
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	
	
	default void description() {
		System.out.println("계산기를 구현한 클래스/인터페이스");
		myMethod();
	}
	
	public static int total(int[] arr) {
		int total = 0;
		
		for(int i : arr) {
			total += i;
		}
		
		myStaticMethod();
		return total;
	}
	
	// private 메소드는 해당 클래스에서 구현을 마쳐야 하며, 해당 클래스의 다른 메소드를 통해서만 사용이 가능함.
	private void myMethod() {
		System.out.println("private 메소드입니다.");
	}
	
	// 아래 메소드를 사용하는 total 메소드가 static이므로, 아래 메소드에도 마찬가지로 static을 선언해준다. 
	private static void myStaticMethod() {
		System.out.println("private static 메소드입니다.");
	}
}
