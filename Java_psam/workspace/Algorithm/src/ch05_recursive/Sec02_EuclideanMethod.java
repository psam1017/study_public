package ch05_recursive;

import java.util.Arrays;

public class Sec02_EuclideanMethod {
	public static void main(String[] args) {
		
		System.out.println("36과 42의 최대 공약수 : " + getGcd(36, 42));
		
		int[] array = {44, 32, 48, 56, 72};
		System.out.println(Arrays.toString(array) + "의 최대 공약수 : " + getGcdArray(array, 0, array.length));
	}
	
	private static int getGcd(int x, int y) {
		return y == 0 ? x : getGcd(y, x % y);
	}
	
	private static int getGcdTwo(int x, int y) {
		
		while(y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		
		return x;
	}
	
	private static int getGcdArray(int[] array, int start, int number) {
		
		if(number == 1) {
			return array[start];
		}
		else if(number == 2) {
			return getGcdTwo(array[start], array[start + 1]);
		}
		else {
			return getGcdTwo(array[start], getGcdArray(array, start + 1, number - 1));
		}
	}
}
