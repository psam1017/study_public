package ch06_class;

public class Class2 {

	public static void main(String[] args) {
		
		// ���� ��Ű�� �ȿ� �ִ� TV Ŭ������ �ν��Ͻ� ����
		TV tv1 = new TV();
		
		tv1.channel = 7;
		tv1.channelDown();
		System.out.println("���� tv1 ä���� " + tv1.channel + "���Դϴ�.");
		
		// ������ Ŭ���������� �ٸ� ��ü(�ν��Ͻ�) ����
		TV tv2 = new TV();
		
		tv2.channel = 35;
		System.out.println("���� tv2 ä���� " + tv2.channel + "���Դϴ�.");
		
		
		
		// ���������� �ǹ�
		System.out.println("\n���� �� ���������� �ּ�");
		System.out.println("tv1 : " + tv1.toString());
		System.out.println("tv2 : " + tv2.toString());
		
		tv1 = tv2;

		System.out.println("\ntv1�� tv2�� ����");
		System.out.println("tv1 : " + tv1.toString());
		System.out.println("tv2 : " + tv2.toString());
		
		System.out.println("\n���� tv1�� tv2�� �ּҸ� �����Ѵ�.");
		System.out.println("���� tv1 ä���� " + tv1.channel + "���Դϴ�.");
		System.out.println("���� tv2 ä���� " + tv2.channel + "���Դϴ�.");
		
		// �ּҸ� ���� �������� �ʾ�����, ������ tv1�� �ּҸ� ã�ư� ����� ����.
	}

}
