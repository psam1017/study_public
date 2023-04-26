package ch02_array_search;

public class Sec04_BinarySearchFirst {
	public static void main(String[] args) {
		
		// ���� �˻����� ���� ���� �� �� ù ��° �� ã��
		
		int length = 50;
		int[] array = new int[length];
		int number = 17;
		int count = 0;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		for(int j = 10; j < 20; j++) {
			array[j] = 17;
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
				while(true) {
					median--;
					if(array[median] != number) {
						median += 2;
						System.out.println(median + "��°�� ������ " + number + "�Դϴ�.");
						break;
					}
				}
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
			System.out.println(count + "ȸ �˻��߽��ϴ�.");
		}
		else {
			System.out.println(number + "��/�� ã�� �� �߽��ϴ�.");
		}
	}
}
