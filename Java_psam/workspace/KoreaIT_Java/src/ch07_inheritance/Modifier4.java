package ch07_inheritance;

public class Modifier4 {
	public static void main(String[] args) {
		
		FinalClass fc = new FinalClass();
		System.out.println(fc.number);
//		fc.number = 10; // 변경 불가능한 상수
		
	}
}

final class FinalClass{
	final int number = 4;
}

class Parents{
	final void finalMethod() {
		System.out.println("상속이 불가하여 오버라이딩할 수 없다.");
	}
}

class Children extends Parents{
//	void finalMethod(); // 오버라이딩 불가능
}