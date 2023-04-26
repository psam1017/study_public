package ch06_sort;

import java.util.Arrays;

public class Sec11_CountingSort extends Swap {
	public static void main(String[] args) {
		
		int[] array = {9, 5, 7, 2, 1, 4, 8, 3, 6};
		int max = array[0];
		
		for(int i : array) {
			if(max < i) {
				max = i;
			}
		}
		
		System.out.println("정렬 전 : " + Arrays.toString(array));
		countingSort(array, max);
		System.out.println("정렬 후 : " + Arrays.toString(array));
	}
	
	private static void countingSort(int[] a, int max) {
		
		int[] f = new int[max + 1];
		int[] b = new int[a.length];
		
		for(int i = 0;						i < a.length;	i++) { f[a[i]]++; }
		for(int i = 1;						i <= max;			i++) { f[i] += f[i - 1]; }
		for(int i = a.length - 1;	i >= 0;				i--) { b[--f[a[i]]] = a[i]; }
		for(int i = 0;						i < a.length;	i++) { a[i] = b[i]; }
	}
}
