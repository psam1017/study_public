package ch01_basic;

public class Sec28_GetMax {
	public static void main(String[] args) {
		
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		
		int max = score[0];
		int min = score[0];
		
		for(int e : score) {
			if(e > max) {
				max = e;
			}
			else if(e < min) {
				min = e;
			}
		}
		
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
	}
}
