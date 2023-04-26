package ch06_sort;

import java.util.Arrays;

public class Sec06_RecursiveQuickSort extends Swap {
	public static void main(String[] args) {
		
		int[] array = {9, 5, 7, 2, 1, 4, 8, 3, 6};
		System.out.println("정렬 전 : " + Arrays.toString(array));
		recursiveQuickSort(array, 0, array.length - 1);
		System.out.println("정렬 후 : " + Arrays.toString(array));
	}
	
	private static void recursiveQuickSort(int[] a, int left, int right) {
		
		// pointer left, pointer right
		int pl = left;
		int pr = right;
		int md = a[(pl + pr) / 2]; // pivot
		
		do {
			while(a[pl] < md) { pl++; }
			while(a[pr] > md) { pr--; }
			if(pl <= pr) {
				swap(a, pl++, pr--);
			}
		} while(pl <= pr);
		
		if(left < pr) {
			recursiveQuickSort(a, left, pr);
		}
		if(right > pl) {
			recursiveQuickSort(a, pl, right);
		}
	}
}
