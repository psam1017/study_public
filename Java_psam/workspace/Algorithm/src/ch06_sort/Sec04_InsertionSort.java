package ch06_sort;

import java.util.Arrays;

public class Sec04_InsertionSort extends Swap {
	public static void main(String[] args) {
		
		int[] array = {9, 5, 7, 2, 1, 4, 8, 3, 6};
		System.out.println("정렬 전 : " + Arrays.toString(array));
		insertionSort(array);
		System.out.println("정렬 후 : " + Arrays.toString(array));
	}
	
	private static void insertionSort(int[] a) {
		
		for(int i = 0; i < a.length; i++) {
			
			int j = i;
			int temp = a[j];
			
			for(j = i; j > 0; j--) {
				if(a[j - 1] > temp) {
					a[j] = a[j - 1];
				}
				else {
					break;
				}
			}
			
			a[j] = temp;
		}
	}
}
