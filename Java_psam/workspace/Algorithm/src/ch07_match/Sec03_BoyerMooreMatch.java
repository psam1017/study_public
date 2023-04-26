package ch07_match;

public class Sec03_BoyerMooreMatch {
	public static void main(String[] args) {
		
		String text = "ABC가나다가나라DEF가나다가나다GHI";
		String pattern = "가나다가나다";
		
		System.out.println("텍스트 : " + text);
		System.out.println("패턴 : " + pattern);
		
		int index = boyerMooreMatch(text, pattern);
		
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
	
	private static int boyerMooreMatch(String text, String pattern) {
		
		int pt ;
		int pp;
		int textLength = text.length();
		int patternLength = pattern.length();
		int[] skip = new int[Character.MAX_VALUE + 1];
		
		// 건너뛰기 표 만들기
		for(pt = 0; pt <= Character.MAX_VALUE; pt++) {
			skip[pt] = patternLength;
		}
		for(pt = 0; pt < patternLength - 1; pt++) {
			skip[pattern.charAt(pt)] = patternLength - pt - 1;
		}
		
		// 검색
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
