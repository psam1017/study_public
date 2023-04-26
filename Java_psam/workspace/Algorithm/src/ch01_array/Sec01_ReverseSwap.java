package ch01_array;

import java.util.Arrays;
import java.util.Random;

public class Sec01_ReverseSwap {
	public static void main(String[] args) {
		
		int length = 7;
		Random random = new Random();
		int[] array = new int[length];
		
		// �ǻ� ���� �����ϱ�
		// random.nextInt(20) -> 0���� 19������ ���� �����ȴ�.
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		
		System.out.println("\n===���ʷ� ������ �迭===");
		System.out.println(Arrays.toString(array));
		
		// ������ ����
		// �迭�� �� ���� �ּҿ� �����ϰ� �����ϱ� ������ �Լ� ���ο��� swap�� ����� ���������� �ݿ��ȴ�. -> Call By Address
		for(int i = 0; i < length / 2; i++) {
			int temp = array[i];
			array[i] = array[length - i - 1];
			array[length - i - 1] = temp;
		}
		
		System.out.println("\n=======������ ���=======");
		System.out.println(Arrays.toString(array));
	}
}
