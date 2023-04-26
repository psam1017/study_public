package ch06_sort;

import java.util.Arrays;

public class Sec09_MergeSort extends Swap {
	public static void main(String[] args) {
		
		int[] array = {9, 5, 7, 2, 1, 4, 8, 3, 6};
		System.out.println("정렬 전 : " + Arrays.toString(array));
		mergeSort(array);
		System.out.println("정렬 후 : " + Arrays.toString(array));
	}
	
	private static int[] buff;
	
	private static void recursiveMergeSort(int[] a, int left, int right) {
		
		if(left < right) {
			int i;
			int center = (left + right) / 2;
			int p = 0;
			int j = 0;
			int k = left;
			
			recursiveMergeSort(a, left, center);
			recursiveMergeSort(a, center + 1, right);
			
			for(i = left; i <= center; i++) {
				buff[p++] = a[i];
			}
			
			while(i <= right && j < p) {
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
			}
			
			while(j < p) {
				a[k++] = buff[j++];
			}
		}
	}
	
	private static void mergeSort(int[] a) {
		
		buff = new int[a.length];
		
		recursiveMergeSort(a, 0, a.length - 1);
		
		buff = null;
	}
}
