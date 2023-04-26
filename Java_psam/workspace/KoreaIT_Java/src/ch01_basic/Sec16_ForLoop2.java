package ch01_basic;

public class Sec16_ForLoop2 {
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 1000000000; i++) {
			;
		}
		long end = System.currentTimeMillis();
		
		System.out.println("소요 시간 : " + (end - start));
	}
}
