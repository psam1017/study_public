package ch07_match;

public class Sec01_BruteForceMatch {
	public static void main(String[] args) {
		
		String text = "ABC������DEF";
		String pattern = "������";
		
		System.out.println("�ؽ�Ʈ : " + text);
		System.out.println("���� : " + pattern);
		
		int index = bruteForceMatch(text, pattern);
		
		if(index == -1) {
			System.out.println("�ش� ���ڿ��� ã�� �� �߽��ϴ�.");
		}
		else {
			System.out.println("�߰��� index : " + index);
			System.out.print("�߰��� ��ġ�� ���ڿ� ���� : ");
			for(int i = index; i < index + pattern.length(); i++) {
				System.out.print(text.charAt(i));
			}
		}
	}
	
	private static int bruteForceMatch(String text, String pattern) {
		
		int pt = 0;
		int pp = 0;
		
		while(pt != text.length() && pp != pattern.length()) {
			if(text.charAt(pt) == pattern.charAt(pp)) {
				pt++;
				pp++;
			}
			else {
				pt = pt - pp + 1;
				pp = 0;
			}
		}
		
		if(pp == pattern.length()) {
			return pt - pp;
		}
		else {
			return -1;
		}
	}
}
