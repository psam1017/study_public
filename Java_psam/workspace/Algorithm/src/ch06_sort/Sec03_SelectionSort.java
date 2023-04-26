package ch06_sort;

import java.util.Arrays;

public class Sec03_SelectionSort extends Swap {
	public static void main(String[] args) {
		
		int[] array = {9, 5, 7, 2, 1, 4, 8, 3, 6};
		System.out.println("정렬 전 : " + Arrays.toString(array));
		selectionSort(array);
		System.out.println("정렬 후 : " + Arrays.toString(array));
	}
	
	private static void selectionSort(int[] a) {
		
		for(int i = 0; i < a.length - 1; i++) {
			
			int min = i;
			for(int j = i + 1; j < a.length; j++) {
				if(a[j] < a[min]) {
					min = j;
				}
			}
			swap(a, i, min);
		}
	}
}
