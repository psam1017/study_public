package ch02_array_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sec06_ObjectBinarySearch {
	public static void main(String[] args) {
		
		// 1. ���ڿ��� ���̰� ������?
		// 2. ���ڿ��� �� �ڸ��� ���ڰ� ������?
		// ���� �䱸 ���� : charAt() �޼ҵ带 ȣ���ϴ� ��� ���� -> ���ڿ��� char �迭�� �ٲپ� �� -> Sec07
		
		final Comparator<String> HANGEUL = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				char c1, c2;
				
				// �� ª�� ���ڿ��� ���̸� ����. length�� ���� ������ ��ġ�Ѵٸ� �� ���� �� ���� ��, �� �� ū ���� ������ ����.
				int length = o1.length() > o2.length() ? o2.length() : o1.length();
				
				// ���ڿ��� ���̰� �ٸ��ٸ�...
				if(o1.length() != o2.length()) {
					for(int i = 0; i < length; i++) {
						c1 = o1.charAt(i);
						c2 = o2.charAt(i);
						
						if(c1 > c2) {
							return 1;
						}
						else if (c1 < c2){
							return -1;
						}
					}
					
					// length��ŭ�� �ݺ��� ��ĥ ������ ���ڿ��� ���ٸ�...
					if(o1.length() > o2.length()) {
						return 1;
					}
					else {
						return -1;
					}
				}
				// ���ڿ��� ���̰� ���ٸ�...
				else {
					for(int i = 0; i < length; i++) {
						c1 = o1.charAt(i);
						c2 = o2.charAt(i);
						
						if(c1 > c2) {
							return 1;
						}
						else if(c1 < c2) {
							return -1;
						}
					}
					
					// ���ڿ� ���̰� ����, ������ ���ڱ��� ���ٸ� ���� ���ڿ��� �Ǵ�
					return 0;
				}
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
		int index = Arrays.binarySearch(array, name, HANGEUL);
		
		if(index >= 0) {
			System.out.println((index + 1) + "��°���� ó������ " + array[index] + "��/�� ã�ҽ��ϴ�.");
		}
		else {
			System.out.println("�迭�� �׷��� �̸��� �����ϴ�.");
		}
	}
}
