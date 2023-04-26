package ch06_sort;

public class Swap {
	
	public static void swap(int[] a, int idx1, int idx2) {
		
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
}
