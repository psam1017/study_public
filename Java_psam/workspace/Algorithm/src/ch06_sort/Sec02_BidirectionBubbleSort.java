package ch06_sort;

import java.util.Arrays;

public class Sec02_BidirectionBubbleSort extends Swap {
	public static void main(String[] args) {
		
		int[] array = {9, 1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println("정렬 전 : " + Arrays.toString(array));
		bidirectionBubbleSort(array);
		System.out.println("정렬 후 : " + Arrays.toString(array));
	}
	
	private static void bidirectionBubbleSort(int[] a) {
		
		int j = 0;
		int k = a.length - 1;
		int l = a.length - 1;
		boolean isOdd = true;
		
		do {
			
			int lastLeft = l;
			int lastRight = l;
			
			if(isOdd) {
				for(int i = l; i > j; i--) {
					if(a[i - 1] > a[i]) {
						swap(a, i - 1, i);
						lastLeft = i;
					}
				}
				j = lastLeft;
				isOdd = !isOdd;
				System.out.println("정렬 좌 : " + Arrays.toString(a));
			}
			else {
				for(int i = 0; i < k; i++) {
					if(a[i] > a[i + 1]) {
						swap(a, i, i + 1);
						lastRight = i;
					}
				}
				k = lastRight;
				isOdd = !isOdd;
				System.out.println("정렬 우 : " + Arrays.toString(a));
			}
		} while(j < l || k < l);
	}
}
