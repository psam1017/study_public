package ch08_abstract_interface_innerclass.innerClassWork;

public class AnonymousClass2 {
	
	// AnonymousClass2의 메소드. Anony2 타입의 객체를 받는다.
	// 아직 인터페이스의 추상메소드는 구현하지 않은 상태이다.
	public void printB(Anony2 a) {
		a.print();
	}
	
	// 필요할 때마다 내부 클래스의 인스턴스로 만들어서 동적으로 추상메소드를 구현
	// 자바와 안드로이드에서는 동일한 방식으로 익명의 내부 클래스를 이용하여 이벤트를 처리한다.
	
	public static void main(String[] args) {
		
		AnonymousClass2 t = new AnonymousClass2();
		// Anony2를 일시적으로, 동적으로 오버라이딩하여 필요한 기능을 구현
		t.printB(new Anony2() {
			@Override
			public void print() {
				System.out.println("익명 클래스 사용!");
			}
		});
		
	}
}

interface Anony2{
	public void print();
}