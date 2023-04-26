package ch06_class;

public class Class1 {

	public static void main(String[] args) {
		
		Car myCar; // 클래스의 객체를 참조할 수 있는 참조변수를 선언.
		myCar = new Car(); // 클래스의 객체를 생성하고, 객체의 주소를 참조변수에 저장.
		
		// 초기화를 하지 않은 경우 클래스 멤버변수의 초기값.
		// 문자형 변수는 null이 아니라 빈 칸(' ')이다.
		System.out.println("시동 초기값 : " + myCar.powerOn);
		System.out.println("색상 초기값 : " + myCar.color);
		System.out.println("바퀴 초기값 : " + myCar.wheel);
		System.out.println("속력 초기값 : " + myCar.speed);
		System.out.println("와이퍼 초기값 : " + myCar.wiperOn);
		
		myCar.power();
		System.out.println("\n시동 메서드 동작 : " + myCar.powerOn);
		
		myCar.power();
		System.out.println("시동 메서드 다시 동작 : " + myCar.powerOn);
		
		myCar.color = "black";
		System.out.println("\n현재 차의 색상 : " + myCar.color);
		
	}

}

// 실습을 위해 Class1 파일 안에 Car 클래스를 생성
class Car {
	
	boolean powerOn;
	String color;
	int wheel;
	int speed;
	boolean wiperOn;
	
	void power() {
		powerOn = !powerOn;
	}
	void speedUp() {
		speed++;
	}
	void speedDown() {
		speed--;
	}
	void wiper() {
		wiperOn = !wiperOn;
	}
}
