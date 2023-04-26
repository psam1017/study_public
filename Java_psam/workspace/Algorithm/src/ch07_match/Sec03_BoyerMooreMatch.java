package ch07_match;

public class Sec03_BoyerMooreMatch {
	public static void main(String[] args) {
		
		String text = "ABC�����ٰ�����DEF�����ٰ�����GHI";
		String pattern = "�����ٰ�����";
		
		System.out.println("�ؽ�Ʈ : " + text);
		System.out.println("���� : " + pattern);
		
		int index = boyerMooreMatch(text, pattern);
		
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
	
	private static int boyerMooreMatch(String text, String pattern) {
		
		int pt ;
		int pp;
		int textLength = text.length();
		int patternLength = pattern.length();
		int[] skip = new int[Character.MAX_VALUE + 1];
		
		// �ǳʶٱ� ǥ �����
		for(pt = 0; pt <= Character.MAX_VALUE; pt++) {
			skip[pt] = patternLength;
		}
		for(pt = 0; pt < patternLength - 1; pt++) {
			skip[pattern.charAt(pt)] = patternLength - pt - 1;
		}
		
		// �˻�
		while(pt < textLength) {
			pp = patternLength - 1;
			
			while(text.charAt(pt) == pattern.charAt(pp)) {
				if(pp == 0) {
					return pt;
				}
				pp--;
				pt--;
			}
			pt += skip[text.charAt(pt)] > patternLength - pp ? skip[text.charAt(pt)] : patternLength - pp;
		}
		
		return -1;
	}
}
