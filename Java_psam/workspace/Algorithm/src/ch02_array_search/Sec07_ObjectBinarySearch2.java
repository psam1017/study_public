package ch02_array_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sec07_ObjectBinarySearch2 {
	public static void main(String[] args) {
		
		final Comparator<String> STRING_COMPARATOR = new Comparator<String>() {
			
			@Override
			public int compare(String v1, String v2) {
				
				char[] o1 = v1.toCharArray();
				char[] o2 = v2.toCharArray();
				
				char c1, c2;
				
				int length = o1.length > o2.length ? o2.length : o1.length;
				
				if(o1.length != o2.length) {
					for(int i = 0; i < length; i++) {
						c1 = o1[i];
						c2 = o2[i];
						
						if(c1 > c2) {
							return 1;
						}
						else if (c1 < c2){
							return -1;
						}
					}
					if(o1.length > o2.length) {
						return 1;
					}
					else if(o1.length < o2.length) {
						return -1;
					}
				}
				else {
					for(int i = 0; i < length; i++) {
						c1 = o1[i];
						c2 = o2[i];
						
						if(c1 > c2) {
							return 1;
						}
						else if(c1 < c2) {
							return -1;
						}
					}
				}
				return 0;
			}
		};
		
		String[] array = new String[]{
				"������", "������", "������", "�迵��", "�迵��",
				"�迵��", "������", "������", "�ڿ���", "�ڿ���",
				"�ڿ���", "���ؼ�", "������", "������", "�̿���",
				"�̿���", "�̿���", "����", "�ֿ���", "�ֿ���",
				"�ֿ���", "�ֿ���", "�ֿ���", "�ֿ���", "Ȳ����"
		};
		
		String name = array[new Random().nextInt(array.length)];
		System.out.println("ã���� �ϴ� �̸� : " + name);
		
		// ���� �˻��� ���� ����
		Arrays.sort(array);
		int index = Arrays.binarySearch(array, name, STRING_COMPARATOR);
		
		if(index >= 0) {
			System.out.println((index + 1) + "��°���� ó������ " + array[index] + "��/�� ã�ҽ��ϴ�.");
		}
		else {
			System.out.println("�迭�� �׷��� �̸��� �����ϴ�.");
		}
	}
}
