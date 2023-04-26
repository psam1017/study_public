package ch06_sort;

import java.util.Arrays;

public class Sec01_BubbleSort extends Swap {
	public static void main(String[] args) {
		
		int[] array = {9, 5, 7, 2, 1, 4, 8, 3, 6};
		System.out.println("정렬 전 : " + Arrays.toString(array));
		bubbleSort(array);
		System.out.println("정렬 후 : " + Arrays.toString(array));
	}
	
	private static void bubbleSort(int[] a) {
		
		int j = 0;
		int l = a.length - 1;
		
		while(j < l) {
			int last = l;
			
			for(int i = l; i > j; i--) {
				if(a[i - 1] > a[i]) {
					swap(a, i - 1, i);
					last = i;
				}
			}
			j = last;
		}
	}
}
