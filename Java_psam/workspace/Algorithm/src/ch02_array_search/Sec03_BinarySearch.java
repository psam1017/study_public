package ch02_array_search;

import java.util.Random;

public class Sec03_BinarySearch {
	public static void main(String[] args) {
		
		/*
		 * ���� �˻�
		 * 
		 * 1. �˻����� �߾Ӱ��� ���ؼ� ������, �Ǵ� �ڷ� �˻��ϴ� ���
		 * 2. (1) ���� ã�ų�, (2) �˻� ������ �� �̻� ���� ��� �˰����� ����ȴ�.
		 * 3. �ڷᱸ���� ���ĵǾ� ���� ���� ����� �� �ִ�.
		 * */
		
		int length = 50;
		int[] array = new int[length];
		int number = new Random().nextInt(length);
		int count = 0;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		System.out.println(number + "��/�� �迭���� �����˻��մϴ�.");
		
		// �� �� index, �� �� index, �߾Ӱ��� �� loop���� ����
		int start = 0;
		int end = length - 1;
		boolean isFound = false;
		
		while(start <= end) {
			int median = (start + end) / 2;
			count++;
			System.out.println("���� �߾Ӱ� : " + median);
			if(number == array[median]) {
				isFound = true;
				break;
			}
			else if(number > median) {
				start = median + 1;
			}
			else {
				end = median - 1;
			}
		}
		
		if(isFound) {
			System.out.println(number + "��/�� ã�ҽ��ϴ�.");
			System.out.println(count + "ȸ �˻��߽��ϴ�.");
		}
		else {
			System.out.println(number + "��/�� ã�� �� �߽��ϴ�.");
		}
	}
}
