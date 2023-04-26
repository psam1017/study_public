package ch01_array;

import java.util.Random;

public class Sec03_ToCardinal {
	public static void main(String[] args) {
		
		Random random = new Random();
		int num = random.nextInt(1024) + 1;
		int cardinal = random.nextInt(16) + 1;
		int length = 0;
		char[] array = new char[11];
		
		System.out.println("생성된 의사 난수 : " + num);
		System.out.println("생성된 기수 : " + cardinal);
		
		length = toCardinal(num, cardinal, array);
		
		System.out.print(cardinal + "진법 변환 결과 : ");
		for(int i = 0; i < length; i++) {
			System.out.print(array[i]);
		}
	}
	
	private static int toCardinal(int num, int cardinal, char[] array) {
		
		int digits = 0;
		String dChar = "0123456789ABCDEF";
		
		while(num != 0) {
			array[digits] = dChar.charAt(num % cardinal);
			num /= cardinal;
			digits++;
		}
		
		for(int i = 0; i < digits / 2; i++) {
			char temp = array[i];
			array[i] = array[digits - i - 1];
			array[digits - i - 1] = temp;
		}
		
		return digits;
	}
}
