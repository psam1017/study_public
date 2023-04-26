package ch01_basic;

public class Sec05_Cast1 {
	public static void main(String[] args) {

		// 자동 형변환
		// 작은 범위에서 큰 범위로 형변환하는 경우 값 손실이 없다.
		// 단, 큰 범위에서 작은 범위로는 자동으로 형변환하지 못 한다. 따라서 명시적 형변환이 필요하다.
		byte a = 127;
		int b = a;
		float c = b;
		System.out.println(c);
		
		// 강제 형변환
		// 강제 형변환을 할 때 자료형의 크기를 초과하는 경우 자료형의 크기만큼 값이 손실된다.
		// 당연하게도, 문자를 숫자, 진위형으로 형변환할 수는 없다. 이 경우 파싱을 사용해야 한다.
		b = (int)c;
		a = (byte)b;
		System.out.println(a);
		
		a = (byte)257;
		System.out.println(a); // (257 - 256 = 1)
	}
}
