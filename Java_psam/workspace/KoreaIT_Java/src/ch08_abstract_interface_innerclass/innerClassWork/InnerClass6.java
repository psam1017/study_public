package ch08_abstract_interface_innerclass.innerClassWork;

public class InnerClass6 {
	public static void main(String[] args) {
		
		OuterClass6 outie = new OuterClass6();
		
		Runnable runnable = outie.getRunnable(10);
		runnable.run();
	}
}

class OuterClass6{
	
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(int i) {
		
		int num = 10;
		
		class MyRunnable implements Runnable{
			
			int localNum = 20;
			
			public void run() {
				// 에러 발생. 메소드 내부의 지역 클래스가 메소드의 지역변수를 사용하지 못함.
				// num = 200; i = 100; // 지역변수와 매개변수는 모두 상수로 처리됨.
				System.out.println("i : " + i);
				System.out.println("num : " + num);
				System.out.println("localNum : " + localNum);
				System.out.println("외부의 인스턴스 멤버 outNum : " + outNum);
				System.out.println("외부의 스태틱 멤버 sNum : " + sNum);
			}
			
		}
		return new MyRunnable();
	}
}