package ch01_basic;

import java.util.Arrays;

public class Sec30_JaggedArray {
	public static void main(String[] args) {
		
		int[][] jArray = {
				{20, 50},
				{15, 25, 35, 45, 55},
				{30, 70, 100},
				{20, 10, 20, 10}
			};
		
		myDeepToString(jArray);
		
		// Arrays.deepToString() : 다차원 배열의 값을 출력
		System.out.println(Arrays.deepToString(jArray));
	}
	
	
	
	public static void myDeepToString(int[][] jArray) {
		System.out.print("[");
		for(int i = 0; i < jArray.length; i++) {
			System.out.print("[");
			for(int j = 0; j < jArray[i].length; j++) {
				System.out.print(jArray[i][j]);
				if(j < jArray[i].length - 1) {
					System.out.print(", ");
				}
			}
			if(i < jArray.length - 1) {
				System.out.print("], ");
			}
		}
		System.out.println("]]");
	}
}
