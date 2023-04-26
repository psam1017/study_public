package ch01_array;

import java.util.Arrays;
import java.util.Random;

public class Sec01_ReverseSwap {
	public static void main(String[] args) {
		
		int length = 7;
		Random random = new Random();
		int[] array = new int[length];
		
		// 의사 난수 생성하기
		// random.nextInt(20) -> 0부터 19까지의 값이 생성된다.
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		
		System.out.println("\n===최초로 생성된 배열===");
		System.out.println(Arrays.toString(array));
		
		// 역으로 스왑
		// 배열은 각 값을 주소에 저장하고 변경하기 때문에 함수 내부에서 swap한 결과가 전역적으로 반영된다. -> Call By Address
		for(int i = 0; i < length / 2; i++) {
			int temp = array[i];
			array[i] = array[length - i - 1];
			array[length - i - 1] = temp;
		}
		
		System.out.println("\n=======역스왑 결과=======");
		System.out.println(Arrays.toString(array));
	}
}
