package ch06_class;

public class Class1 {

	public static void main(String[] args) {
		
		Car myCar; // Ŭ������ ��ü�� ������ �� �ִ� ���������� ����.
		myCar = new Car(); // Ŭ������ ��ü�� �����ϰ�, ��ü�� �ּҸ� ���������� ����.
		
		// �ʱ�ȭ�� ���� ���� ��� Ŭ���� ��������� �ʱⰪ.
		// ������ ������ null�� �ƴ϶� �� ĭ(' ')�̴�.
		System.out.println("�õ� �ʱⰪ : " + myCar.powerOn);
		System.out.println("���� �ʱⰪ : " + myCar.color);
		System.out.println("���� �ʱⰪ : " + myCar.wheel);
		System.out.println("�ӷ� �ʱⰪ : " + myCar.speed);
		System.out.println("������ �ʱⰪ : " + myCar.wiperOn);
		
		myCar.power();
		System.out.println("\n�õ� �޼��� ���� : " + myCar.powerOn);
		
		myCar.power();
		System.out.println("�õ� �޼��� �ٽ� ���� : " + myCar.powerOn);
		
		myCar.color = "black";
		System.out.println("\n���� ���� ���� : " + myCar.color);
		
	}

}

// �ǽ��� ���� Class1 ���� �ȿ� Car Ŭ������ ����
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
