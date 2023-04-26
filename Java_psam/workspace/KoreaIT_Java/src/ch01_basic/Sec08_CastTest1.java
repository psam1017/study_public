package ch01_basic;

public class Sec08_CastTest1 {
	public static void main(String[] args) {

		// 변수 4개를 사용하고, + 연산자만 사용하여 9를 출력
		long var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		
		// 변수를 모두 더하면 10.7
		// 변수의 정수부만 더하면 8
		// 무언가 하나는 소수점을 깎아야 한다.
		int result = (int)(var1 + var2 + var3 + (int)Double.parseDouble(var4));
		System.out.println(result);
	}
}
