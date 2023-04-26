package ch06_class;

public class Class2 {

	public static void main(String[] args) {
		
		// 같은 패키지 안에 있는 TV 클래스로 인스턴스 생성
		TV tv1 = new TV();
		
		tv1.channel = 7;
		tv1.channelDown();
		System.out.println("현재 tv1 채널은 " + tv1.channel + "번입니다.");
		
		// 동일한 클래스이지만 다른 객체(인스턴스) 생성
		TV tv2 = new TV();
		
		tv2.channel = 35;
		System.out.println("현재 tv2 채널은 " + tv2.channel + "번입니다.");
		
		
		
		// 참조변수의 의미
		System.out.println("\n현재 각 참조변수의 주소");
		System.out.println("tv1 : " + tv1.toString());
		System.out.println("tv2 : " + tv2.toString());
		
		tv1 = tv2;

		System.out.println("\ntv1에 tv2를 저장");
		System.out.println("tv1 : " + tv1.toString());
		System.out.println("tv2 : " + tv2.toString());
		
		System.out.println("\n이제 tv1도 tv2의 주소를 저장한다.");
		System.out.println("현재 tv1 채널은 " + tv1.channel + "번입니다.");
		System.out.println("현재 tv2 채널은 " + tv2.channel + "번입니다.");
		
		// 주소를 따로 저장하지 않았으니, 기존의 tv1의 주소를 찾아갈 방법이 없다.
	}

}
