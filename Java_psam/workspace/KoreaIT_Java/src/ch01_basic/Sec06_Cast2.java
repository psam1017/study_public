package ch01_basic;

public class Sec06_Cast2 {
	public static void main(String[] args) {

		// 파싱의 예시
		int i = Integer.parseInt("10");
		String str = String.valueOf(10);
		
		System.out.println(i + 10); // 20
		System.out.println(str + 10); // 1010
	}
}
