package ch01_basic;

public class Sec02_Type1 {
	public static void main(String[] args) {
		// 정수형 : byte, short, int, long
		// 실수형 : float, double
		// 진위형 : boolean
		// 문자형 : char, String
		
		// 실수는 부동 소수점의 오류가 생기므로, 실수끼리 계산하려면 BigDecimal 클래스를 사용해야 한다.
		// float의 접미사는 f, double의 접미사는 L이다.
		// double을 사용할 때, int 범위 안에서라면 접미사를 생략해도 되지만, 이를 벗어날 경우 반드시 접미사를 붙여야 한다.
		
		byte b = 127;
		short sh = 32767;
		int i = 4;
		long l = 8;
		final double PI = 3.14;
		float f = 3.14f;
		boolean bool = false;
		char c = 'c';
		String s = "Hello World";
		
		System.out.print(b +" ");
		System.out.print(sh +" ");
		System.out.print(i +" ");
		System.out.print(l +" ");
		System.out.println();
		System.out.print(PI +" ");
		System.out.print(f);
		System.out.println();
		System.out.print(bool);
		System.out.println();
		System.out.print(c +" ");
		System.out.print(s);
		System.out.println();
		
		System.out.println((int)c); // c의 아스키 코드 값은 99이다.
		System.out.println((char)97); // 97의 아스키 코드 문자는 a이다.
	}
}
