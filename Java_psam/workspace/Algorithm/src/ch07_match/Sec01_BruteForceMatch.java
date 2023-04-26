package ch07_match;

public class Sec01_BruteForceMatch {
	public static void main(String[] args) {
		
		String text = "ABC가나다DEF";
		String pattern = "가나다";
		
		System.out.println("텍스트 : " + text);
		System.out.println("패턴 : " + pattern);
		
		int index = bruteForceMatch(text, pattern);
		
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
