package ch07_match;

public class Sec04_IndexOf {
	public static void main(String[] args) {
		
		String text = "ABC�����ٰ�����DEF�����ٰ�����GHI";
		String pattern = "�����ٰ�����";
		
		System.out.println("�ؽ�Ʈ : " + text);
		System.out.println("���� : " + pattern);
		
		new String().equals(pattern);
		
		int index = text.indexOf(pattern);
		
		if(index == -1) {
			System.out.println("�ش� ���ڿ��� ã�� �� �߽��ϴ�.");
		}
		else {
			System.out.println("�߰��� index : " + index);
			System.out.print("�߰��� ��ġ�� ���ڿ� ���� : " + text.substring(index, index + pattern.length()));
		}
	}
}
