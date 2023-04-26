package ch01_array;

import java.util.ArrayList;
import java.util.Random;

public class Sec02_ToBinary {
	public static void main(String[] args) {
		
		int num = new Random().nextInt(1024) + 1;
		System.out.println("생성된 숫자 : " + num);
		System.out.println();
		System.out.println("이진법으로 변환 : " + toBinary(num));
	}
	
	private static String toBinary(int num) {
		
		ArrayList<String> list = new ArrayList<>(); // 1024로 한정할 경우 char[] array = new char[11];
		
		// 처음 및 중간 반복 처리
		while(num / 2 != 0) {
			list.add(Integer.toString(num % 2));
			num /= 2;
		}
		// 마지막 값 처리
		list.add("1");
		
		String binary = "";
		
		for(int i = list.size() - 1; i > -1; i--) {
			binary += list.get(i);
		}
		
		return binary;
	}
}
