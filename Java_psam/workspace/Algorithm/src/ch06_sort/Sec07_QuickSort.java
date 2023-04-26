package ch06_sort;

import java.util.Arrays;

public class Sec07_QuickSort extends Swap {
	public static void main(String[] args) {
		
		int[] array = {9, 5, 7, 2, 1, 4, 8, 3, 6};
		System.out.println("정렬 전 : " + Arrays.toString(array));
		betterQuickSort(array, 0, array.length - 1);
		System.out.println("정렬 후 : " + Arrays.toString(array));
	}
	
	private static int sort3(int[] array, int a, int b, int c) {
		if(array[b] < array[a]) { swap(array, b, a); }
		if(array[c] < array[b]) { swap(array, c, b); }
		if(array[b] < array[a]) { swap(array, b, a); }
		return b;
	}
	
	private static void betterQuickSort(int[] a, int left, int right) {
		
		int pl = left;
		int pr = right;
		int md = sort3(a, pl, (pl + pr) / 2, pr);
		int x = a[md];
		
		swap(a, md, right - 1);
		pl += 1;
		pr -= pr > 1 ? 2 : 1;
		
		do {
			while(a[pl] < x) { pl++; }
			while(a[pr] > x) { pr--; }
			if(pl <= pr) {
				swap(a, pl++, pr--);
			}
		} while(pl <= pr);
		
		if(left < pr) {
			betterQuickSort(a, left, pr);
		}
		if(right > pl) {
			betterQuickSort(a, pl, right);
		}
	}
}
