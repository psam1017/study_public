package ch08_abstract_interface_innerclass.innerClassWork;

public class AnonymousClass1 {
	public static void main(String[] args) {
		
		Anony1 outie = new Anony1();
		
		Runnable runnable = outie.getRunnable(10);
		runnable.run();
		
		outie.runnable.run();
		
	}
}

class Anony1{
	
	Runnable getRunnable(int i) {
		
		int num = 100;
		
		// 1) 메소드를 호출할 때 생성.
		// 익명 내부 클래스. return을 위해 한 번만 사용하므로 내부 익명 함수를 사용.
		// return에서 바로 클래스를 생성.
		return new Runnable() {
			
			@Override
			public void run() {
				System.out.println(i);
				System.out.println(num);
			}
		};
	}
	
	// 2) 참조 변수에 대입할 때 new 예약어를 사용하여 클래스를 생성. run()만 오버라이딩하기 위해 사용.
	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			System.out.println("Runnable이 구현된 익명 클래스 변수");
		}
	};
}
