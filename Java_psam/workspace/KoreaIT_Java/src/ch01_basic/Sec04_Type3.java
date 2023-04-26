package ch01_basic;

public class Sec04_Type3 {
	public static void main(String[] args) {

		// + 연산자는 읽어들이는 데로 우선순위를 가진다.
		// 덧셈 연산자인지 결합 연산자인지에 따른 우선순위는 없다.
		// 피연산자 중 하나라도 문자열이면 나머지 피연산자도 문자열로 자동 형변환된다.
		
		int value = 10 + 2 + 8; // 20
		String str = 10 + 2 + "8"; // 128
		str = 10 + "2" + 8; // 1028
		str = "10" + 2 + 8; // 1028
		str = "10" + (2 + 8); // 1010
		
		System.out.println(value + str); // 201010
	}
}
