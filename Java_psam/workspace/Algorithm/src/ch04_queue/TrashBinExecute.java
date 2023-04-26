package ch04_queue;

public class TrashBinExecute {
	public static void main(String[] args) {
		
		// ring buffer�� ������� ���� ������ �����͸� ������ �뵵�� ���α׷��� �����ϴ�.
		
		TrashBin<String> bin = new TrashBin<>(5);
		
		bin.put("�þ�1");
		bin.put("�þ�2");
		bin.put("�þ�3");
		bin.put("�þ�_����");
		
		System.out.println("\n=====���� 4���� ���Ƚ��ϴ�.=====\n");
		bin.show();
		
		bin.put("�þ�_����2");
		bin.put("�þ�_��¥_����");
		bin.put("�þ�_final");
		
		System.out.println("\n=====���� 3���� �� ���Ƚ��ϴ�.=====\n");
		bin.show();
		
		System.out.println("\n=====���� '�þ�_final'�� �����մϴ�.=====\n");
		System.out.println("���� ��� : " + bin.restore(1));
		
		System.out.println("\n=====�������� ���ϴ�.=====\n");
		bin.clear();
		
		System.out.println("\n=====������ û�� ���=====\n");
		bin.show();
	}
}
