package ch02_array_search;

import java.util.Arrays;
import java.util.Random;

public class Sec02_Sentinel {
	public static void main(String[] args) {
		
		/*
		 * (�ݺ����� �迭 ���� ������� ���� ��Ȳ����)�˻��� ���� ������ 2�����̴�.
		 * 
		 * 1. �˻��� ���� �߰����� ���ϰ� �ڷḦ ��� �˻��� ���
		 * 2. �˻��� ���� ���� ��Ҹ� �߰��� ���
		 * 
		 * �̶�, 1���� ���� �Ǵ� ������ ���� �ϱ� ���� ����� ���ʹ��̴�.
		 * ���ʹ������� ã���� �ϴ� ���� ���� �������� �δµ�, �̷��� �ϸ� �迭�� ������ ������ 2���� �����ϱ� ������ 1�� ������ �ʿ� ���� �ȴ�.
		 * ������, ��κ��� ��� ���� ���ʹ��� ������ �� ���� �ʴ�.
		 * */
		
		Random random = new Random();
		int num = 10;
		int[] array = new int[num + 1]; // array[num]���� ������ ã���� �ϴ� ���� ����.

		int value = 5;
		
		for(int i = 0; i < array.length - 1; i++) {
			array[i] = random.nextInt(10) + 1;
		}
		array[num] = value;
		
		System.out.println(Arrays.toString(array));
		
		int n = 0;
		while(true) {
			if(array[n] == value) { // ���� �������� �˻� ���� ��������Ƿ� ������ loop�� Ż���� �� �ִ�.
				break;
			}
			n++;
		}
		
		if(n == num) {
			System.out.println("���� ã�� �� �߽��ϴ�.");
		}
		else {
			System.out.println(n + "��°���� 5�� ã�ҽ��ϴ�.");
		}
	}
}
