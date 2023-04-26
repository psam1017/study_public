package ch01_basic;

public class Sec24_CallByValue {
	public static void main(String[] args) {

		int num1 = 20;
		int num2 = 100;
		System.out.println("num1 : " + num1 + ", and num2 : " + num2);
		
		swap(num1, num2);
		System.out.println("num1 : " + num1 + ", and num2 : " + num2);
	}
	
	// 값에 의한 복사 : 함수 안에서 지역적으로 값을 주고 받았을 뿐이다.
	// 함수를 종료하면 각 변수는 원래 지니고 있던 값을 가리킨다.
	public static void swap(int num1, int num2) {
		int temp = num1;
		num1 = num2;
		num2 = temp;
		System.out.println("swap done?");
	}
}
