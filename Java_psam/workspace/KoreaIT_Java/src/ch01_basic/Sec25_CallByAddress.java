package ch01_basic;

public class Sec25_CallByAddress {
	public static void main(String[] args) {

		int[] num1 = {20};
		int[] num2 = {100};
		System.out.println("num1 : " + num1[0] + ", and num2 : " + num2[0]);
		
		swap(num1, num2);
		System.out.println("num1 : " + num1[0] + ", and num2 : " + num2[0]);
	}
	
	// 주소에 의한 복사 : 각각의 주소 값을 교환하였다.
	// 이는 메모리를 직접적으로 건드리는 것이므로 함수가 종료된 후에도 값이 바뀌어있다.
	public static void swap(int[] num1, int[] num2) {
		int temp = num1[0];
		num1[0] = num2[0];
		num2[0] = temp;
		System.out.println("swap done!");
	}
}
