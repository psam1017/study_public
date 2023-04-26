package ch07_match;

import java.util.Arrays;

public class Sec02_KMP {
	public static void main(String[] args) {
		
		String text = "ABC가나다가나라DEF가나다가나다GHI";
		String pattern = "가나다가나다";
		
		System.out.println("텍스트 : " + text);
		System.out.println("패턴 : " + pattern);
		
		int index = kmpMatch(text, pattern);
		
		if(index == -1) {
			System.out.println("해당 문자열을 찾지 못 했습니다.");
		}
		else {
			System.out.println("발견한 index : " + index);
			System.out.print("발견한 위치의 문자열 추출 : ");
			for(int i = index; i < index + pattern.length(); i++) {
				System.out.print(text.charAt(i));
			}
		}
	}
	
	private static int kmpMatch(String text, String pattern) {
		
		int pt = 1;
		int pp = 0;
		int[] skip = new int[pattern.length() + 1];
		
		// 건너뛰기 표 만들기
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
		
		System.out.println("생성된 패턴 표ㅂ : " + Arrays.toString(skip));
		
		// 검색
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
