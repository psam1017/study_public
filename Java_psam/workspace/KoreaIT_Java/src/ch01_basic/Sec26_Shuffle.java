package ch01_basic;

import java.util.Arrays;

public class Sec26_Shuffle {
	public static void main(String[] args) {

		int[] numList = new int[45];

		for(int i = 0; i < numList.length; i++) {
			numList[i] = i + 1;
		}
		
		for(int i = 0; i < 1000; i++) {
			int rand = (int)Math.floor((Math.random() * numList.length));
			
			int temp = numList[rand];
			numList[rand] = numList[0];
			numList[0] = temp;
		}
		
		// Arrays.toString() : 배열 내부의 값들을 출력
		System.out.println(Arrays.toString(numList));
	}
}
