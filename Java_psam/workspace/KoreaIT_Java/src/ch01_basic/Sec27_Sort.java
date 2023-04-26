package ch01_basic;

import java.util.Arrays;

public class Sec27_Sort {
	public static void main(String[] args) {

		int[] numList = {5, 3, 9, 1, 4, 7};
		
		for(int i = 1; i < numList.length; i++) {
			for(int j = i; j > 0; j--) {
				// 주석과 같이 조건을 변경하면 역순으로 정렬된다.
				// numList[j] > numList[j - 1]
				if(numList[j] < numList[j - 1]) {
					int temp = numList[j];
					numList[j] = numList[j - 1];
					numList[j - 1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(numList));
	}
}
