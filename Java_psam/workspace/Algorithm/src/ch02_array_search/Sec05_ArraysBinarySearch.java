package ch02_array_search;

import java.util.Arrays;
import java.util.Random;

public class Sec05_ArraysBinarySearch {
	public static void main(String[] args) {
		
		int length = 30;
		int[] array = new int[length];
		Random random = new Random();
		
		int number = random.nextInt(50) + 1;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(30) + 1;
		}
		
		System.out.println("�˻��� ���� : " + number);
		System.out.println("===������ �迭(���� ��)===");
		System.out.println(Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("===������ �迭(���� ��)===");
		System.out.println(Arrays.toString(array));
		System.out.println("===���� �˻� ����===");
		int index = Arrays.binarySearch(array, number);
		
		if(index > 0) {
			System.out.println(index + "��°���� ���ڸ� ã�ҽ��ϴ�.");
		}
		else {
			System.out.println("���ڸ� ã�� �� �߽��ϴ�.");
		}
	}
}
