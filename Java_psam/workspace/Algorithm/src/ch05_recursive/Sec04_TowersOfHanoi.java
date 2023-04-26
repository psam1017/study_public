package ch05_recursive;

public class Sec04_TowersOfHanoi {
	
	public static void main(String[] args) {
		
		int count = 3;
		System.out.println("������ ���� : " + count);
		
		move(count, 1, 3);
	}
	
	private static void move(int num, int one, int ano) {
		
		// �� ���� ���� ��տ�
		if(num > 1) {
			move(num - 1, one, 6 - one - ano);
		}
		
		System.out.println("����[" + num + "]��/�� " + one + "�� ��տ��� " + ano + "�� ������� �ű�ϴ�.");
		
		// �� ���� ���� ��տ�
		if(num > 1) {
			move(num - 1, 6 - one - ano, ano);
		}
	}
}
