package ch07_inheritance;

public class Polymorphism4 {
	public static void main(String[] args) {
		
		Car car;
		FireTruck fe1 = new FireTruck();
		FireTruck fe2;
		
		// 업캐스팅은 자동 형변환이 되지만 다운캐스팅은 형변환을 명시해야 한다.
		// 즉, 자식 타입 참조변수는 부모 타입 인스턴스를 참조할 수 없다.
		
		car = fe1;
		fe2 = (FireTruck)car;
		
//	car.water(); // 부모 그릇에 없는 메소드를 사용할 수는 없다. 
		fe1.water();
		fe2.water();
	}
}

class Car{
	String color;
	int door;
	
	void drive() {System.out.println("drive!");}
	void stop() {System.out.println("stop!");}
}

class FireTruck extends Car{
	void water() {System.out.println("extinguish!");}
}