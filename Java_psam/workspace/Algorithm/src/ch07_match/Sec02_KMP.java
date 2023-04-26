package ch07_match;

import java.util.Arrays;

public class Sec02_KMP {
	public static void main(String[] args) {
		
		String text = "ABC�����ٰ�����DEF�����ٰ�����GHI";
		String pattern = "�����ٰ�����";
		
		System.out.println("�ؽ�Ʈ : " + text);
		System.out.println("���� : " + pattern);
		
		int index = kmpMatch(text, pattern);
		
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
	
	private static int kmpMatch(String text, String pattern) {
		
		int pt = 1;
		int pp = 0;
		int[] skip = new int[pattern.length() + 1];
		
		// �ǳʶٱ� ǥ �����
		skip[pt] = 0;
		while(pt != pattern.length()) {
			if(pattern.charAt(pt) == pattern.charAt(pp)) {
				skip[++pt] = ++pp;
			}
			else if(pp == 0) {
				skip[++pt] = pp;
			}
			else {
				pp = skip[pp];
			}
		}
		
		System.out.println("������ ���� ǥ�� : " + Arrays.toString(skip));
		
		// �˻�
		pt = pp = 0;
		while(pt != text.length() && pp != pattern.length()) {
			if(text.charAt(pt) == pattern.charAt(pp)) {
				pt++;
				pp++;
			}
			else if(pp == 0) {
				pt++;
			}
			else {
				pp = skip[pp];
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
