package ch01_basic;

public class Sec15_ForLoop1 {
	public static void main(String[] args) {
		
		int sum = 0;
		int lastNum = 10;
		for(int i = 0; i <= lastNum; i++) {
			sum += i;
			System.out.print(i);
			if(i != lastNum) {
				System.out.print(", ");
			}
		}
		System.out.println("\n합계 : " + sum);
	}
}
