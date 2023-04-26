package ch02_array_search;

import java.util.Arrays;
import java.util.Random;

public class Sec05_ArraysBinarySearch {
	public static void main(String[] args) {
		
		int length = 30;
		int[] array = new int[length];
		Random random = new Random();
		
		int number = random.nextInt(50) + 1;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(30) + 1;
		}
		
		System.out.println("검색할 숫자 : " + number);
		System.out.println("===생성된 배열(정렬 전)===");
		System.out.println(Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("===생성된 배열(정렬 후)===");
		System.out.println(Arrays.toString(array));
		System.out.println("===이진 검색 시작===");
		int index = Arrays.binarySearch(array, number);
		
		if(index > 0) {
			System.out.println(index + "번째에서 숫자를 찾았습니다.");
		}
		else {
			System.out.println("숫자를 찾지 못 했습니다.");
		}
	}
}
