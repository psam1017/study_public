package ch07_match;

public class Sec04_IndexOf {
	public static void main(String[] args) {
		
		String text = "ABC가나다가나라DEF가나다가나다GHI";
		String pattern = "가나다가나다";
		
		System.out.println("텍스트 : " + text);
		System.out.println("패턴 : " + pattern);
		
		new String().equals(pattern);
		
		int index = text.indexOf(pattern);
		
		if(index == -1) {
			System.out.println("해당 문자열을 찾지 못 했습니다.");
		}
		else {
			System.out.println("발견한 index : " + index);
			System.out.print("발견한 위치의 문자열 추출 : " + text.substring(index, index + pattern.length()));
		}
	}
}
